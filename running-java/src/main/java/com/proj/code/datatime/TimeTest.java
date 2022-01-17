package com.proj.code.datatime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2020, 7, 1);
        long between1 = ChronoUnit.DAYS.between(now, of);
        Instant daysAgo = Instant.now().plus(2, ChronoUnit.HOURS);
        System.out.println(daysAgo);
        System.out.println(between1);

        int i = of.getDayOfYear() - now.getDayOfYear();
        System.out.println(i);
    }
}
