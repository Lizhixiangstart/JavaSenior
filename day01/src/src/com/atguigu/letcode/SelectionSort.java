package src.com.atguigu.letcode;

/**选择排序
 * @author lzx
 * @create 2022-04-2022/4/9 16:27
 */
public class SelectionSort {
    public static void main(String[] args) {
    int[] arr = new int[]{2,5,6,8,3,9};
        int[] arr1 = new int[]{4,65,2,111,56,33,267};
       selectionsort(arr1);
       for (int i:arr1){
           System.out.print(i+",");
       }
    }

    public static int[] selectionsort(int[] arr){
        if (arr.length ==0){
            return arr;
        }else{
            for (int i=0;i<arr.length-1;i++){
                int maxIndex = i;
                //从小到大排
                for (int j=i+1;j<arr.length;j++){
                    if (arr[i]>arr[j]){
                        arr[i]=arr[i]^arr[j];
                        arr[j]=arr[i]^arr[j];
                        arr[i]=arr[i]^arr[j];
                    }
                }
            }
            return arr;
        }
    }
}
