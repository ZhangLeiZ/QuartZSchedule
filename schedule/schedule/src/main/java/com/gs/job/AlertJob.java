package com.gs.job;

import org.springframework.stereotype.Component;

/**
 * @author xiaopeng
 * @date 2018/3/15 9:24
 */
@Component
public class AlertJob {

    public void run() {
        System.out.println("警告！！！");
    }

}
