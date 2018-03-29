package com.s2u2m.javaresearch.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;


public class DateTest {

    @Test
    public void utilDate() {
        Date ud = new Date();
        // 断点到Date的toString, 看时区信息
        System.out.println(ud);
    }

    @Test
    public void setZoneForDate() {
        // 设置默认时区
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("GMT+7")));
        Date ud = new Date();
        // 断点到Date的toString, 看时区信息
        System.out.println(ud);
    }

    @Test
    public void diffOutput() {
        // 设置格式化以及对于的时区, 即被格式化的时间串为该时区的时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        String dateStr = "2013-1-31 22:17:14";
        try {
            Date dateTmp = dateFormat.parse(dateStr);
            // 使用Date本身的默认时区输出
            System.out.println(dateTmp); // Fri Feb 01 06:17:14 CST 2013
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date date = new Date(1359641834000L);// 2013-1-31 22:17:14
        String dateStrTmp = dateFormat.format(date);
        System.out.println(dateStrTmp);
    }

    @Test
    public void useDefaultZone() {
        // 没有显式设置时区, 默认为系统时区
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.getTimeZone().getID());

        String dateStr = "2013-1-31 22:17:14";
        try {
            // Date也没有显示设置时区, 默认为系统时区
            Date date = dateFormat.parse(dateStr);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date date = new Date(1359641834000L);// 2013-1-31 22:17:14
        String dateStrTmp = dateFormat.format(date);
        System.out.println(dateStrTmp);
    }

    @Test
    public void setZone() {
        // 没有显式设置时区, 默认为系统时区
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        System.out.println(dateFormat.getTimeZone().getID());

        String dateStr = "2013-1-31 22:17:14";
        try {
            // Date也没有显示设置时区, 默认为系统时区GMT+8
            Date date = dateFormat.parse(dateStr);
            System.out.println(date); // 由于相差1小时, 所以Thu Jan 31 23:17:14 CST 2013
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 使用绝对时间初始化Date
        Date date = new Date(1359641834000L);// 2013-1-31 22:17:14, 时区为GMT+8
        System.out.println(date);
        String dateStrTmp = dateFormat.format(date);
        System.out.println(dateStrTmp); // 2013-01-31 21:17:14

        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("GMT+6")));
        Date date1 = new Date(1359641834000L);// 2013-1-31 22:17:14, 时区为GMT+8
        System.out.println(date1); // 2013-01-31 20:17:14 时区为GMT+6
    }

}
