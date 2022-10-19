package src.com.atguigu.letcode;

/**插入排序
 * @author lzx
 * @create 2022-04-2022/4/9 17:08
 */
public class InsertionSort {
    public static void main(String[] args) {
    int[] arr = new int[]{22,57,12,2,73,32};
    insertionsort(arr);
    for (int i:arr){
        System.out.print(i+",");
    }
    }
    public static void insertionsort(int[] arr){
        if (arr.length==0){
            System.out.println("输入数据非法");
        }else{
            //外层循环控制要插入元素的下标
            for (int i=1;i< arr.length;i++){
                //内层循环判断将要插入的位置(从小到大排)
                for (int j=0;j<i;j++){
                    if (arr[i]<arr[j]){
                        //将要插入的元素插入到指定指定位置
                       int temp = arr[i];
                        //将j后面的元素全都往后移一位
                      for (int k=i;k>j;k--){
                          arr[k]=arr[k-1];
                      }
                       arr[j]=temp;
                    }
                }
            }
        }
    }
    public static int[] sort(int[] array){
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
