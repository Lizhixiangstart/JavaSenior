package com.atguigu.java1;

import java.lang.annotation.*;

/**
 * @author lzx
 * @create 2022-03-2022/3/3 13:39
 */
@Inherited

@Retention(RetentionPolicy.RUNTIME)


public @interface MyAnnotation {
    String value() default "hello";
}
