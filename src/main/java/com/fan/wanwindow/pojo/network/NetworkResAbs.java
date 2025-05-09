package com.fan.wanwindow.pojo.network;


/**
 * @Author: ODM
 * @Date: 2024-08-04 09:30
 * @Description:
 * @Version: v1.0
 */


public abstract class NetworkResAbs<T> implements NetworkRes{
    public String code;
    public String msg;
    public T data;
}
