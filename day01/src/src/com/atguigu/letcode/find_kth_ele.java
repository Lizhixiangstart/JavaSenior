package src.com.atguigu.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 题目描述：
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * ————————————————
 * 版权声明：本文为CSDN博主「王培琳」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44171872/article/details/107531883
 * @author lzx
 * @create 2022-03-2022/3/24 19:52
 */
public class find_kth_ele  {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4};
        List<Integer> list = new ArrayList<>();
        //将元素添加到集合中
        for (int i : nums1){
            list.add(i);
        }
        for (int i : nums2){
            list.add(i);
        }
        //将集合中的元素排序
        for (int i =0;i< list.size()-1;i++){
            for (int j=0;j< list.size()-1-i;j++){
                if (list.get(j)> list.get(j+1)){
                    int temp = list.get(j);
                    list.add(j,list.get(j+1));
                    list.add(j+1,temp);

                }
            }
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] array = Arrays.copyOf(nums1, nums1.length + nums2.length);

            for (int i = 0; i < nums2.length; i++) {
                array[nums1.length + i] = nums2[i];

            }

            if (array.length == 0)

                return 0.0;

            if (array.length == 1)

                return array[0];

            Arrays.sort(array);

            if(array.length % 2 == 1){
                return array[array.length / 2 ];

            }else{
                return (array[array.length / 2] + array[array.length / 2 - 1] ) / 2.0;

            }


    }
}
