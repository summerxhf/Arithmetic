import java.util.Arrays;

/**
 * Created by fang on 2017/11/14.
 * 排序算法，java描述
 */
public class SortArithmetic {
    final int MAX = 5;
    int num[] = new int[MAX];
    //构造块
    {
        System.out.println("生成的随机数组是：");
        for(int i = 0;i<5;i++){
            num[i] = (int)(Math.random() * 100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public SortArithmetic(){
//        bubSort(num.clone()); //冒泡排序法。
//        selectSort(num.clone()); //选择排序法。
        quickSort_one(num.clone());//快速排序法。

    }

    public static void main(String[] args) {
        System.out.println("开始执行..........");
        new SortArithmetic();
    }

    /**
     * 冒泡排序法。
     * 1 每次都把最大的数字冒到最右端。
     * 2 每次都要两两比较，需要交换进行交换，每次需要两两比较次数减1；
     * @param number
     */
    public void bubSort(int[] number) {
        long start,end;
        start = System.nanoTime();//返回的是纳秒。
        int i,j ,temp;
        for (i=0;i < MAX-1;i++){//n个数字，要冒n-1趟。MAX 为生成数组的长度，也就是number.length。
            for(j=0;j< MAX -i -1 ;j++){//每趟比较交换,每趟两两比较都递减。
                if(number[j] > number[j+1]){
                    //进行交换,把大的数放到后面。
                    temp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;
                }
            }

        }
        end = System.nanoTime();

        System.out.println("----------------冒泡排序法--------------");
        System.out.println("排序后是：");
        for(i = 0;i<MAX;i++){
            System.out.print(number[i] + " ");
        }

        System.out.println();
        System.out.println("排序使用时间：" + (end - start) + " ns");//使用纳秒数字。
    }

    //选择排序法。
    public void selectSort(int[] number){
        long start,end;
        start = System.nanoTime();//返回的是纳秒。
        int i ,j, minSubscript;//最小下标
        for(i = 0;i<number.length-1;i++){//每趟都规定一个最小的数。
            //找每趟的最小的数。
            minSubscript = i;//每趟都认为开始的是最小数的下标。
            for(j= i + 1;j< number.length ;j++){
                if(number[j]<number[minSubscript]){
                    minSubscript = j;
                }
            }
            if(minSubscript!=i){
                //找到了交换首位置。
                int temp;
                temp = number[i];
                number[i] = number[minSubscript];
                number[minSubscript] = temp;
            }
        }
        end = System.nanoTime();
        System.out.println("----------------选择排序法--------------");
        System.out.println("排序后是：");
        for(i = 0;i<MAX;i++){
            System.out.print(number[i] + " ");
        }

        System.out.println();
        System.out.println("排序使用时间：" + (end - start) + " ns");//使用纳秒数字。

    }

    //快速排序
    public void quickSort_one(int number[]){
        long start,end;
        start = System.nanoTime();
        quickSort_1(number,0,MAX-1);
        end = System.nanoTime();
        System.out.println("------------快速排序法（一）-----------");
        System.out.println("排序后是：");
        for(int i = 0;i<=MAX-1;i++){
            System.out.print(number[i] + " ");
        }
        System.out.println();
        System.out.println("排序使用时间：" + (end - start) + " ns");
    }

    public void quickSort_1_error(int[] number, int low, int high) {//low 和high分别指向数组的头和尾。
        int need_location_element,temp,start,end;
        start = low;
        end = high;//记录每次的开始和结尾。

        if(high<=low){//递归结束的条件，就是没有可以分半的数组了。每次都要拆分。
            return;
        }
        high = high +1;
        //当low>high
        need_location_element = number[start];
        while (true){
            //low找到比基数大的，而high找到比基数小的，交换两边的数。
            while (low<high  &&number[++low]<need_location_element  ){//左边开始找大于基数的

            }
            while (low<high && number[--high]>need_location_element){//右边开始找小于基数的。

            }
             if(high>low){
                 //交换两个位置。
                 temp = number[low];
                 number[low] = number[high];
                 number[high] = temp;
                 for(int j=0;j<MAX;j++){
                     System.out.print(number[j] + " ");
                 }
                 System.out.println("");

             }

            //基准数与之交换。
            if(high<=low){
               temp = number[start];
               number[start] = number[high-1];
                number[high-1] = temp;
                for(int j=0;j<MAX;j++){
                    System.out.print(number[j] + " ");
                }
                System.out.println("");
                break;
            }

        }
        //然后递归掉用。
        quickSort_1_error(number,start,low-1);//左侧递归。
        quickSort_1_error(number,low,end);//右侧递归。
        for(int j=0;j<MAX;j++){
            System.out.print(number[j] + " ");
        }
        System.out.println("");

    }


    //[2, 42, 95, 4, 51, 67, 93, 63, 93, 43, 39, 92, 34, 51, 64, 83, 88, 0, 37, 85]
    public void quickSort_1(int[] num, int start, int end) {
        int left, right, current, temp;
        if (start < end) {
            current = num[start];
            left = start;
            right = end + 1;
            while (true) {
                while (true) {
                    if (left >= end || num[++left] > current) {
                        break;
                    }
                }
                while (true) {
                    if (right <= start || num[--right] < current) {
                        break;
                    }
                }
                if (left >= right) {
                    break;
                }
                temp = num[left];
                num[left] = num[right];
                num[right] = temp;
            }
            num[start] = num[right];
            num[right] = current;
            System.out.println(Arrays.toString(num));
            quickSort_1(num, start, left - 1);
            quickSort_1(num, right + 1, end);
        }
    }
}
