package com.gs.schedule;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author xiaopeng
 * @date 2018/3/14 10:19
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务");
                timer.cancel();
            }
        }, 3 * 1000);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 2, 14, 10, 26, 30);
        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务");
                timer1.cancel();
            }
        }, calendar.getTime());
    }

}
