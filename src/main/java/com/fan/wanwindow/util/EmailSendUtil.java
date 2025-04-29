package com.fan.wanwindow.util;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

public class EmailSendUtil {
    public final static String EMAIL_MY = "1524834513@qq.com";
    public final static String MONITOR_STATUS_FAIL = "Issue Broken";
    public final static String PASS_EMAIL = "bhkpbqkpnugdbaei";


    public static void sendToMyEmail(String content){
        MailAccount account = new MailAccount();
        account.setFrom(EMAIL_MY);
        account.setUser(EMAIL_MY);
        account.setPass(PASS_EMAIL);
        account.setSslEnable(true);
        MailUtil.send(account, EMAIL_MY, MONITOR_STATUS_FAIL, content, false);
    }

    public static void main(String[] args) {
        sendToMyEmail("测试一下啦");
    }
}
