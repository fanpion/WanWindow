package com.fan.wanwindow.aop;

import com.fan.wanwindow.annotation.WebLog;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public * com.fan.wanwindow.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 获取 @WebLog 注解的描述信息
        String methodDescription = getAspectLogDescription(joinPoint);

        // 打印请求相关参数
        log.info("========================================== Start ==========================================");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印描述信息
        log.info("Description    : {}", methodDescription);
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        for (Object arg : joinPoint.getArgs()) {
            log.info("Request Args   : {}", arg);
            //joinPoint.getSignature().getName();
        }

        //log.info("Request Args   : {}", String.valueOf(joinPoint.getArgs().toString()));
    }

    @After("webLog()")
    public void doAfter() {
        log.info("========================================== End ==========================================" + System.lineSeparator());
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
