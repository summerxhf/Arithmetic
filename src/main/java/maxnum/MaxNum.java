package maxnum;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/1/2
 * Time: 10:15
 */
public class MaxNum {
    public static void main(String[] args) {
        int arr[] = {1,4,5,8,9,2,3};
        int max = getMax(arr);
        System.out.println("最大值为--" + max);
    }

    /**
     * 用第一个位数字为基准数
     * @param arr
     * @return
     */
    public static int getMax(int arr[]){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;

    }

}
