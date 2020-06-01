package com.monkey.gateway.util;

import java.time.ZonedDateTime;

public class TimeUtil {

    /**
     * 获取时间区2020-06-01T22:50:13.690+08:00[Asia/Shanghai]
     * @param args
     */
    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time.toString());

    }
}
