package com.dreamcoffee.spring.boot.demo;

import java.util.Timer;
import java.util.TimerTask;

import static org.awaitility.Awaitility.await;

/**
 * AwaitilityDemo
 *
 * @author Administrator
 * @date 2019/5/31
 */
public class AwaitilityDemo {

    public static void main(String[] args) {
        final int[] a = {0};
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                a[0] += 1;
                System.out.println(a[0]);
            }
        }, 0, 1000);
        await().until(() -> a[0] == 5);
        timer.cancel();
    }
}
