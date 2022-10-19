import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**JDk8中日期时间API的测试
 *
 * @author lzx
 * @create 2022-02-2022/2/24 14:00
 */
public class JDk8DateTimeTest {
    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2020-1990,9-1,8);
        System.out.println(date1);//Mon Sep 08 00:00:00 CST 1930




    }

    /*
        LocalDate、LocalTime、LocalDateTimie的使用
        说明：
        1.LocalDateTimie相较于LocalDate、LocalTime使用频率要高
        2.类似于Calendar
        * */
    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx():获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        
        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(3);
        System.out.println(localDateTime2);
        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localTime);
        System.out.println(localDateTime4);


    }




   /*
    Instant的使用
    类似于java.util.Date类
    */
   @Test
    public void test2() {
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2022-02-24T07:05:53.708432200Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取1970年1月1日0时0分0秒(UTC)开始的豪秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数计算/获取I nstanct实例-->Date实例
        Instant instant1 = Instant.ofEpochMilli(1645687009087L);
        System.out.println(instant1);


    }
    /*
    * DateTimeFormatter:格式化或解析日期与时间
    * 类似于SimpleDateFormat
    *
    * */
    @Test
    public void test3(){
        //方式一： 预定义的标准格式。如:ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            //格式化:日期-->字符串
            LocalDateTime localDateTime = LocalDateTime.now();
            String str1 = formatter.format(localDateTime);
            System.out.println(localDateTime);
            System.out.println(str1);
            //解析：字符串-->日期
        TemporalAccessor parse = formatter.parse(str1);
        System.out.println(parse);

        //方式二： 本地化相关的格式:如:ofLocalizdDateTime(FormatStyle.Long)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
            //格式化：
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2022/2/24 下午3:43

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);
        //重点：方式三： 自定义的格式如：ofPattern("yyyy-MM-dd hh:mm:ss E")
            //格式化：
            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String str4 = formatter3.format(LocalDate.now());
            System.out.println(str4);

            //解析：
        TemporalAccessor parse1 = formatter3.parse("2022-02-24");
        System.out.println(parse1);
    }
}
