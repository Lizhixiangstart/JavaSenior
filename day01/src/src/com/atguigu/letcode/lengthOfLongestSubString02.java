package src.com.atguigu.letcode;

/**
 * 求两个字符串共同的最长字串
 * @author lzx
 * @create 2022-03-2022/3/23 17:57
 */
public class lengthOfLongestSubString02 {
    public static void main(String[] args) {
    String str1 = "cmlovelzx";
    String str2 = "lzxispig" ;
        lengthOfLongestSubString02 test = new lengthOfLongestSubString02();
        String str = test.lengthOfLongestSubString02(str1,str2);
        System.out.println(str);
    }
    //获取两个字符串中最长的字串
    public String  lengthOfLongestSubString02(String str1,String str2) {
        String max = (str1.length() >= str2.length()) ? str1 : str2;
        String min = (str1.length() <= str2.length()) ? str1 : str2;

        for (int i=0;i<min.length();i++){
           for (int j=0;j<min.length();j++){
              for (int k=min.length()-i;k<min.length();k++){
                  String str = min.substring(j,k);
                  if (max.contains(str)){
                      return str;
                  }
              }
           }
        }
        return null;
    }

}
