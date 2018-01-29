package com.s2u2m.javaresearch.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JavaResearchTimeMain {
    public static void main(String[] args) {

        long now = TimeUtil.epochMsFromNow();
        Instant feature = Instant.ofEpochMilli(now).plusMillis(3000);
        long elapseMs = TimeUtil.elapseMs(now, feature.toEpochMilli());
        System.out.println(elapseMs == 3000);

        /**
         * LocalDateTime 本地时间, 默认时区根据系统设置的时区来计算
         */
        LocalDateTime gmt08 = LocalDateTime.now();
        System.out.println(gmt08);

        /**
         * ZonedDateTime 时区时间,
         */
        ZonedDateTime gmt00 = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(gmt00);

        String ts = TimeUtil.timeStr(now, ZoneId.of("GMT+08"));
        System.out.println(ts);

    }
}
