package com.atguigu;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于class java.lang.Enum
 * @author lzx
 * @create 2022-03-2022/3/1 23:42
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Season1.class.getSuperclass());
        Season1[] values = Season1.values();
        for (int i=0;i<values.length;i++){
            System.out.println(values[i]);
        }
        //valueOf(String objName):返回枚举类中对下你个名是objName的对象
        //如果没有objName的枚举类对象则抛异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }

}
interface Info{
    void show();
}

//使用enum定义枚举类
enum Season1 implements Info{
    //1.提供当前类的多个对象,多个对象之间用,隔开，末尾对象用;
      SPRING ("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天");
        }
    },
      SUMMER ("夏天","夏日炎炎"){
          @Override
          public void show() {
              System.out.println("夏天");
          }
      },
      AUTUMN ("秋天","秋高气爽"){
          @Override
          public void show() {
              System.out.println("秋天");
          }
      },
      WINTER ("冬天","冰天雪地"){
          @Override
          public void show() {
              System.out.println("冬天");
          }
      };

    //1.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //2.私有化构造器,并给属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    //4.提供诉求1：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String  getSeasonDesc() {
        return seasonDesc;
    }
    //4.提供诉求2：提供toString()


    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}

