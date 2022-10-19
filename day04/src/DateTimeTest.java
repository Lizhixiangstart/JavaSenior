import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk8.0之前的日期和时间的API测试
 * 1.System类中CurrentTimeMillis();
 * 2.java.util.Date类和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 * @author lzx
 * @create 2021-12-2021/12/29 23:22
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1格式化：日期 --->字符串
    1.2解析：格式化的逆过程，字符串 --->日期
    
    2.SimpleDateFormat的实例化
    

     */
   @Test
   public void testSimpleDateFormate() throws ParseException {
       //实例化SimpleDateFormat
       SimpleDateFormat sdf = new SimpleDateFormat();

       //格式化:日期 --->字符串
       Date date = new Date();
       //System.out.println(date);

       String format = sdf.format(date);
       System.out.println(format);

       //解析：格式化的逆过程,字符串-->日期
       String str = "2022/02/23 下午14:45";
       Date date1 = sdf.parse(str);
       System.out.println(date1);

       //********************按照指定的方式格式化和解析：调用带参的构造器*************
//       SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd.GGG hh:mm aaa");

       SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd.GGG hh:mm aaa");
//       解析：要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现）。
       String str1 = sdf1.format(date);
       System.out.println(str1);


       /*
       练习一：字符串”2020-09-08“转换为Java.sql.Date
       练习二：”三天打鱼两天晒网“ 1990-01-01    xxxx-xx-xx

       举例：2002-09-08  ?  总天数

       总天数 %5 == 1，2，3 ：打渔
       总天数%5 ==4，0 ：晒网

       总天数的计算？
       方式一：(date2.getTime() - date1.getTime()) / (1000*60*60*24)天+1
       方式二：1990-01-01 --> 2020-12-31 + 2020-01-01-->2020-09-08
        */




   }


    @Test
    public void testExer() throws ParseException {
        String birth = "2022-02-23";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);//Java util下的date
//        System.out.println(date);

        java.sql.Date birthday = new java.sql.Date(date.getTime());
        System.out.println(birthday);
        }
//        calendar日历类(抽象类)的使用
    @Test
    public void testCalendar(){
       //1.实例化
        //方式一：创建其子类(GregorianCalendar)的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar= Calendar.getInstance();
        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
         days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //getTime():日历类-->Date
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime():Date --> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(date1);


    }

   }
