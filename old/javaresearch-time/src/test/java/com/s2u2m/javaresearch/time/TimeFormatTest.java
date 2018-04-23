package com.s2u2m.javaresearch.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatTest {

    @Test
    public void date2str() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC+8"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String rst = formatter.format(zonedDateTime);
        System.out.println(rst);
    }

    @Test
    public void str2date() {
        DateTimeFormatter lf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse("2018-03-28 12:10:30", lf);
        System.out.println(ldt);

        DateTimeFormatter zf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssx");
        ZonedDateTime zdt = ZonedDateTime.parse("2018-03-28 12:10:30+08", zf);
        System.out.println(zdt);
    }

}
