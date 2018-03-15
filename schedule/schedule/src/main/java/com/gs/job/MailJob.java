package com.gs.job;

import org.springframework.stereotype.Component;

/**
 * @author xiaopeng
 * @date 2018/3/15 8:41
 */
@Component
public class MailJob {

    public void run() {
        System.out.println("发送邮件……");
    }

}
