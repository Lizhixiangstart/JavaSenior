package com.atguigu.java4;

/**
 * @author lzx
 * @create 2022-05-2022/5/21 11:12
 */
public class Boy {
    private Girl girl;

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }
}
