package others;

import java.util.Random;

public class BlockCounterTest {
    // 生成一个随机的二维数组
    public static int[][] createRandomArr(int rows, int cols) {
        Random random = new Random();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                float n = random.nextFloat();
                arr[i][j] = Math.round(n);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] testArr = createRandomArr(4, 4);
        BlockCounter blockCounter = new BlockCounter(testArr);
        blockCounter.setDefaultReset(false);// 此语句影响grid数组内容,如非默认重置则需要手动重置,必须在count执行前设置
        System.out.println("原数组:");
        blockCounter.showGrid();
        System.out.println("区块数:" + blockCounter.count());
        System.out.println("处理后数组:");
//        // blockCounter.reset();
        blockCounter.showGrid();
    }
}
