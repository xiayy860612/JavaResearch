package com.s2u2m.javaresearch.time;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.*;

public class TimeConvertTest {
    private int year = 1986;
	private int month = 7;
	private int day = 22;
	private int hour = 11;

	@Test
    public void instantOfZone() {
	    // Instant时间始终以epoch为原点
        long local = System.currentTimeMillis();
        System.out.println(local);

	    long utcMs = Instant.now().toEpochMilli();
	    System.out.println(utcMs);

	    long utc7 = Instant.now(Clock.system(ZoneId.of("UTC+7"))).toEpochMilli();
	    System.out.println(utc7);
    }

    @Test
    public void convertLocal2Zone() {
        // 本地时间
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, 0);
        System.out.println(date);
        // 本地时间不包含将时区信息, 可设置为任意时区, 但时间信息不会发生变化
        ZonedDateTime zdt = date.atZone(ZoneId.of("UTC+9"));
        System.out.println(zdt);
        assertEquals(hour, zdt.getHour());

        zdt = date.atZone(ZoneId.of("UTC+7"));
        System.out.println(zdt);
        assertEquals(hour, zdt.getHour());
    }

    @Test
    public void convertInstantAndZone() {
        // 本地时区的时间
        ZonedDateTime date = ZonedDateTime.of(year, month, day,
                hour, 0, 0, 0,
                ZoneId.of("UTC+8"));
        System.out.println(date);

        Instant inst = date.toInstant();
        ZonedDateTime actual = ZonedDateTime.ofInstant(inst, ZoneId.of("UTC+8"));
        assertEquals(date.getHour(), actual.getHour());

        ZonedDateTime nzdt = inst.atZone(ZoneId.of("UTC"));
        System.out.println(nzdt);
        assertEquals(hour-8, nzdt.getHour());
    }

    @Test
    public void instInDiffZone() {
	    Instant inst = Instant.now();

	    ZonedDateTime utc8 = inst.atZone(ZoneId.of("UTC+8"));
	    System.out.println(utc8);

        ZonedDateTime utc7 = inst.atZone(ZoneId.of("UTC+7"));
        System.out.println(utc7);

        assertEquals(utc8.getHour()-1,utc7.getHour());
    }
}
