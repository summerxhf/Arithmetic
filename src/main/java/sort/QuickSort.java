package sort;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * 快速排序;
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] ax={1,2,5,9,5,4,3,0,0};
        quickSort(ax,0,ax.length-1);
        for (int i = 0; i < ax.length; i++) {
            System.out.print(ax[i]+ " ");
        }
    }
    public static void quickSort(int arr[],int left ,int right){
        if(left>right){
            return;
        }
        //找到最左侧的基准数;
        int base = arr[left];
        int i = left;
        int j = right;
        //以基准数为基础,从右侧找到小于基准数的数字;
        //以基准数为基础,从左侧开始找到大于基准数的数字;
        while (i!=j){
            while (arr[j]>=base && i<j){
                j--;
            }
            while (arr[i]<=base && i<j){
                i++;
            }
            //找到后交换两个数;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //交换基准数,left==right;
        arr[left] = arr[i];
        arr[i] = base;

        //继续剩下的左边的集合;
        quickSort(arr,left,i-1);
        //继续剩下的右边的集合;
        quickSort(arr,j+1,right);
    }
}
