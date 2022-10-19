package src.com.atguigu.letcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述：
 * 题解 (9.5k)
 * 提交记录
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author lzx
 * @create 2022-03-2022/3/21 20:22
 */
public class lengthOfLongestSubString {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s){
        //先进行判断输入的数据是否为空，若数据为空返回0
        if(s ==null || s.length()<1){
            return 0;
        }
        //若输入的数据不为空，则进行判断
        //将输入的字符串转换为char型数组
        char[] chars = s.toCharArray();
        int size = 0;
        //双层for循环，获取数组中所有不重复的字串
        for (int i=0;i<s.length();i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<s.length();j++){
               if (set.contains(chars[j])){
               break;
               }
               set.add(chars[j]);
               //每次获取完成后比较得到字串的长度，筛选出最长值
               size=set.size() > size ? set.size():size;
            }

            }
            return size;
    }
}
