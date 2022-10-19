package src.com.atguigu.letcode;

/**
 * 题目描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * ————————————————
 * 版权声明：本文为CSDN博主「王培琳」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44171872/article/details/107149119
 * @author lzx
 * @create 2022-03-2022/3/21 20:09
 */
public class getSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        System.out.println(new getSum().getSum(arr,9));
    }

    public String getSum(int[] arr, int target) {
        //如果输入的数组不为空，则进行枚举
        if (arr.length != 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == target) {
                        System.out.println("["+i+","+j+"]");
                    }
                }
            }
            //若输入的数据非法
        } else {
            System.out.println("输入的数据非法");
        }

       return "方法已完成";
    }
}