package com.proj.code.datatime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataTimeTest {

    @Test
    public void method01() {
        for (int i = 0; i < 10000; i++) {
            long currentTime = System.currentTimeMillis();

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 10);
            calendar.set(Calendar.MINUTE, 17);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Date date = calendar.getTime(); //第一次执行定时任务的时间
            long time = date.getTime();

            if ((time - 10 * 60 * 1000) < currentTime && currentTime < time) {//10分钟内不执行任何操作
                System.out.println(time);
                System.out.println(currentTime);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (currentTime > time && currentTime < time + 1566 * 5) {

                System.out.println("1111111111111111111111");
            }
        }
    }


    @Test
    public void method02() {
        // 时间文本
        String dateText = "2018-04-10T10:33:08.72";
        // 格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

        long time = 0;
        try {
            time = formatter.parse(dateText).getTime();
            System.out.println(formatter.parse(dateText));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(time);
    }
}
