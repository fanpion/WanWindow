package com.fan.wanwindow.aop;

import com.alibaba.fastjson2.JSON;
import com.fan.wanwindow.annotation.WebLog;
import com.fan.wanwindow.entity.SysIpReq;
import com.fan.wanwindow.entity.SysRequestLog;
import com.fan.wanwindow.entity.id.SysIpReqPK;
import com.fan.wanwindow.entity.id.SysRequestLogPK;
import com.fan.wanwindow.pojo.network.SysIpReqPO;
import com.fan.wanwindow.pojo.network.SysIpReqReq;
import com.fan.wanwindow.pojo.network.SysIpReqReqCity;
import com.fan.wanwindow.pojo.network.SysIpReqRes;
import com.fan.wanwindow.pojo.network.tencent.*;
import com.fan.wanwindow.service.LogService;
import com.fan.wanwindow.util.NetworkUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.*;

import static com.fan.wanwindow.util.EmailSendUtil.sendToMyEmail;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Autowired
    LogService<SysRequestLog> requestLogService;

    @Qualifier("sysIpReqLogServiceImpl")
    @Autowired
    LogService sysIpReqLog;

    // TODO: if address is in warning list
    public static List<String> warningList = new ArrayList<>();

    static{
        warningList.add("广州市");
        warningList.add("台州市");
    }

    public final static String LOG_START_STRING = "========================================== Start ==========================================";
    public final static String LOG_END_STRING = "==========================================  END  ==========================================";
    public final static String NEW_LINE_STRING = System.lineSeparator();

    @Pointcut("execution(public * com.fan.wanwindow.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        // email send flag
        boolean anyMatch = false;

        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 获取 @WebLog 注解的描述信息
        String methodDescription = getAspectLogDescription(joinPoint);

        StringBuilder logSb = new StringBuilder(LOG_START_STRING).append(NEW_LINE_STRING);
        String url = request.getRequestURL().toString();
        String des = methodDescription;
        String httpMethod = request.getMethod();
        Enumeration<String> headerNames = request.getHeaderNames();

        String relIp = null;
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
            if ("x-real-ip".equals(headerName)){
                relIp = headerValue;
            }
        }

        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String url_ip = request.getRemoteAddr();
        if (null != url_ip && "127.0.0.1".equals(url_ip) && null != relIp) {
            url_ip = relIp;
        }
        String url_address = null;

        // IP
        SysIpReq sysIpReq = null;
        // city level
//        SysIpReqReqCity sysIpReqReqCity = new SysIpReqReqCity(url_ip);
//        String responseC = NetworkUtil.get(sysIpReqReqCity.merge().getFinalUrl());
//        SysIpReqRes sysIpReqResC = JSON.parseObject(responseC, SysIpReqRes.class);
//        System.out.println("City"+responseC);
//        System.out.println("City"+sysIpReqResC);


        // TODO: query IP and Save
        SysIpReqReq sysIpReqReq = new SysIpReqReq(url_ip);
        HashMap<String, String> header = new HashMap<>();
        header.put("Referer", "https://qifu.baidu.com/");
        String response = NetworkUtil.get(sysIpReqReq.merge().getFinalUrl(), header);
        SysIpReqRes sysIpReqRes = JSON.parseObject(response, SysIpReqRes.class);
        System.out.println(response);
        System.out.println(sysIpReqRes);
        // save
        SysIpReqPO data= null;
        if(sysIpReqRes != null){
            data = sysIpReqRes.data;

            if (data != null) {
                sysIpReq = new SysIpReq(new SysIpReqPK(sysIpReqRes.ip, sysIpReqRes.code,data.continent, data.country, data.zipcode, data.timezone,
                        data.accuracy, data.owner, data.isp, data.source, data.areacode, data.adcode, data.asnumber, data.lat,
                        data.lng, data.redius, data.prov, data.city, data.district, new Date()));
                String city = data.city;
                anyMatch = warningList.stream().anyMatch(str -> str.equals(city));

            } else{
                sysIpReq = new SysIpReq(new SysIpReqPK(sysIpReqRes.ip, sysIpReqRes.code, new Date()));
            }
            sysIpReqLog.log(sysIpReq);
            if ("Success".equals(sysIpReqRes.code)) {
                url_address = sysIpReqRes.data.prov + " " + sysIpReqRes.data.city + " " + sysIpReqRes.data.district;
            }
        }




        // Tencent IP
        SysIpReqTenReq sysIpReqTenReq = new SysIpReqTenReq(url_ip);
        String s = NetworkUtil.get(sysIpReqTenReq.finalUrl);
        System.out.println(s);
        SysIpReqTenPO tenPO = JSON.parseObject(s, SysIpReqTenPO.class);

        SysIpReqTenResult result = tenPO.result;
        if ("0".equals(tenPO.status)){
            SysIpReqTenLoc loc =  result.location;
            SysIpReqTenAdInfo info = result.ad_info;
            url_address = result.ad_info.province + " " + result.ad_info.city + " " + result.ad_info.district;
            /**
             *         this.ip = ip;
             *         this.code = code;
             *         this.reqTime = reqTime;
             *
             *         this.lat = lat;
             *         this.lng = lng;
             *         this.country = country;
             *         this.prov = prov;
             *         this.city = city;
             *         this.district = district;
             *         this.adCode = adCode;
             *         this.areaCode = areaCode;
             */
            sysIpReq = new SysIpReq(new SysIpReqPK(url_ip, tenPO.status, new Date(), loc.lat, loc.lng, info.nation, info.province,
                    info.city, info.district, info.adcode, info.nation_code));
            anyMatch |= warningList.stream().anyMatch(str -> str.equals(result.ad_info.city));
        } else {
            sysIpReq = new SysIpReq(new SysIpReqPK(url_ip, tenPO.status, new Date()));
        }
        sysIpReqLog.log(sysIpReq);

        String req_params = String.join(", ", Arrays.stream(joinPoint.getArgs()).map(Object::toString).toArray(String[]::new));
        String reqParamsKey = String.join(", ", ((MethodSignature) joinPoint.getSignature()).getParameterNames());
        logSb.append(url).append(NEW_LINE_STRING);
        logSb.append(des).append(NEW_LINE_STRING);
        logSb.append(httpMethod).append(NEW_LINE_STRING);
        logSb.append(className).append(NEW_LINE_STRING);
        logSb.append(methodName).append(NEW_LINE_STRING);
        logSb.append(url_ip).append(NEW_LINE_STRING);
        logSb.append(req_params).append(NEW_LINE_STRING);
        logSb.append(reqParamsKey).append(NEW_LINE_STRING);


        // 打印请求相关参数
        log.info(logSb.toString());

        SysRequestLog sysRequestLog = new SysRequestLog(new SysRequestLogPK(url, des, httpMethod, className, methodName, url_ip, url_address, req_params, reqParamsKey, new Date()));
        // TODO: save log into db
        requestLogService.log(sysRequestLog);
        if (anyMatch) {
            String finalUrl_address = url_address;
            new Thread(()->sendToMyEmail(finalUrl_address + " 访问了!" + sysRequestLog)).start();
            // sendToMyEmail(url_address + " 访问了!" + sysRequestLog);
        }

        //log.info("Request Args   : {}", String.valueOf(joinPoint.getArgs().toString()));
    }

    @After("webLog()")
    public void doAfter() {
        log.info(LOG_END_STRING + System.lineSeparator());
    }

    public String getAspectLogDescription(JoinPoint joinPoint) throws Exception {

        String targetName = joinPoint.getTarget().getClass().getName();

        String methodName = joinPoint.getSignature().getName();

        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);

        Method[] methods = targetClass.getMethods();

        StringBuilder description = new StringBuilder();

        WebLog annotation = null;
        // Check Method
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    annotation = method.getAnnotation(WebLog.class);
                    if (annotation != null) {
                        description.append("[" + method.getAnnotation(WebLog.class).description() + "]");
                    } else {
                        description.append("[" + methodName + "]");
                    }
                    break;
                }
            }
        }

        if (annotation == null) {
            annotation = Class.forName(targetName).getAnnotation(WebLog.class);
            if (annotation != null) {
                description.append(Class.forName(targetName).getAnnotation(WebLog.class).description());
            }
        }

        return description.toString();

    }

}
