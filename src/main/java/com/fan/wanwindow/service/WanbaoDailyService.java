package com.fan.wanwindow.service;

public interface WanbaoDailyService {

    public String GetGoodsTrade(String cookie);
    public String getGoodDetail(int updateIDFrom);
    public String updateSysConfigCookie(String cookie);
    public String getSysConfigCookie();
}
