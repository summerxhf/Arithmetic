/**
 * Created by fang on 2017/11/11.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 222));
        System.out.println(binSearch(srcArray,222));
        System.out.println(orderSearch(srcArray,81));
    }

    /**
     * 二分查找递归实现。
     * @param srcArray  有序数组
     * @param low 数组低地址下标
     * @param high   数组高地址下标
     * @param key  查找元素
     * @return 查找元素不存在返回-1
     */
    public static int binSearch(int srcArray[], int low, int high, int key) {
        int mid = (high  - low) / 2 + low;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (low >= high) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, high, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, low, mid - 1, key);
        }
        return -1;
    }

    /**
     * 二分查找普通实现。
     * @param srcArray 有序数组
     * @param key 查找元素
     * @return  不存在返回-1
     */
    public static int binSearch(int srcArray[], int key) {
        int mid = srcArray.length / 2;
        if (key == srcArray[mid]) {
            return mid;
        }

        int low= 0;
        int high = srcArray.length - 1;
        while (low<= high) {
            mid = (high - low) / 2 + low;
            if (key < srcArray[mid]) {
                high = mid - 1;
            } else if (key > srcArray[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 顺序查找
     * @param srcArray
     * @param key
     * @return
     */
    public static int orderSearch(int srcArray[],int key){
        for(int i=0;i<srcArray.length-1;i++){
            if(key == srcArray[i]){
                return i;
            }
        }
        return -1;
    }
}
