package com.fan.wanwindow.util;


/**
 * @Author: ODM
 * @Date: 2024-08-04 09:09
 * @Description:
 * @Version: v1.0
 */


import com.alibaba.fastjson2.JSON;
import com.fan.wanwindow.pojo.network.SysIpReqReq;
import com.fan.wanwindow.pojo.network.SysIpReqRes;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class NetworkUtil {
    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON_TYPE = MediaType.get("application/json; charset=utf-8");

    /**
     * 执行GET请求
     * @param url 请求的URL
     * @return 响应的字符串
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                return response.body().string();
            }
        }
        return url;
    }

    public static String get(String url, Map<String, String> param) throws IOException {
        Request.Builder url1 = new Request.Builder().url(url);
        if (param != null) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                url1.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Request request = url1.build();
        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                return response.body().string();
            }
        }
        return url;
    }

    /**
     * 执行POST请求，发送JSON数据
     * @param url 请求的URL
     * @param json 发送的JSON字符串
     * @return 响应的字符串
     */
    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON_TYPE);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        SysIpReqReq sysIpReqReq = new SysIpReqReq("119.129.227.100");
        String response = NetworkUtil.get(sysIpReqReq.merge().getFinalUrl());
        SysIpReqRes sysIpReqRes = JSON.parseObject(response, SysIpReqRes.class);

        System.out.println(sysIpReqRes);
        System.out.println(response);
    }
}
