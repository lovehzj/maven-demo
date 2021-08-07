package com.github.shoothzj.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hezhangjian
 */
@Slf4j
public class TimeTest {

    @Test
    public void nanoTimeTest() {
        final long nanoTime = System.nanoTime();
        log.info("nano time is {}", nanoTime);
    }

    @Test
    public void testTimestamp() {
        String timeStamp = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC"))
                .format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
        log.info("ts is {}", timeStamp);
    }

}
