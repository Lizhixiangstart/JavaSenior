package com.atguigu.java4;

import org.junit.Test;

import java.util.Optional;

/**
 *
 * Optional类：为了在程序中避免出现空指针异常而创建的
 *
 * 常用方法：
 *          offNullable(T t)
 *          orElse(T t)
 * @author lzx
 * @create 2022-05-2022/5/21 11:13
 */
public class OptionalTest {

    /*
    * Optional.of(T t):创建一个Optional实例，t必须非空
    * Optional.empty():创建一个空的Optional实例
    * Optional.ofNullable(T t):t可以为null
    *
    * */

    @Test
    public void test1(){
        Girl girl = new Girl();
        girl=null;
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);
    }
    @Test
    public void test2(){
        Girl girl = new Girl();
        girl=null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        //orElse(T t):如果当前的Optional内部封装的t是非空的，则返回内部的t
        //如果内部的t则返回orElse内部方法中的参数t1
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);

    }
    @Test
    public void test3w(){

    }
    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        boy=null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后girlGetName():
    public String girlGetName1(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        boy=null;
        String girlName = girlGetName1(boy);
        System.out.println(girlName);

    }
    //使用Optional类的girlGetName():
    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();

        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));

        return girl1.getName();


    }

    @Test
    public void test5(){
       Boy boy = null;
       boy = new Boy(new Girl("苍老师"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}
