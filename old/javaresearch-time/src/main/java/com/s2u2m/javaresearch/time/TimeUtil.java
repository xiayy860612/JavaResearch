package com.s2u2m.javaresearch.time;

import static java.time.format.DateTimeFormatter.*;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;

/**
 * The type Time util.
 * @author xiayy860612
 */
public class TimeUtil {

    public static long epochMsFromNow() {
        /**
         * Instant表示的以新纪元(epoch)的时间为原点的时间线上的某个时间点,
         * 可精确到纳秒
         */
        Instant ins = Instant.now();
        // ms elapse from 1970.1.1 00:00:00
        long epochMs = ins.toEpochMilli();
        System.out.println(epochMs);
        return epochMs;
    }

    public static long elapseMs(long start, long end) {
        Instant startIns = Instant.ofEpochMilli(start);
        Instant endIns = Instant.ofEpochMilli(end);

        // Duration 用于计算两个Instant之间的时间差, 可精确到纳秒
        Duration elapse = Duration.between(startIns, endIns);
        long elapseMs = elapse.toMillis();
        System.out.println(elapseMs);
        return elapseMs;
    }

    public static String timeStr(long ms, ZoneId zoneId) {
        Instant time =Instant.ofEpochMilli(ms);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(time, zoneId);
        /**
         * DateTimeFormatter 用于格式化时间
         * ISO_OFFSET_DATE_TIME 基于iso-8601标准来显示时间格式
         */
        return ISO_OFFSET_DATE_TIME.format(zdt);
    }
}
