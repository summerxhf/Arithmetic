package others;
/**
 * 数组区块数量判断:
 * 1.给出一个二维数组,数组内容值为(0或1);
 * 2.值为1的连续区块识别为一块,单独的独立区块也识别为一块;
 * 3.判断得到的块的数量(类似于地图判断房屋数量).
 * @author xhf
 */
public class BlockCounter {
    private static final int SOMETHING = 1;
    private static final int NOTHING = 0;

    private int[][] grid;
    private int rows;
    private int cols;
    private boolean defaultReset = false;

    public BlockCounter(int[][] arr) {
        grid = arr;
        rows = grid.length;
        cols = grid[0].length;
    }

    public boolean hasSomething(int i, int j) {
        return grid[i][j] == SOMETHING;
    }

    public boolean isAlone(int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i + 1][j] == NOTHING && grid[i][j + 1] == NOTHING;
        } else if (i == 0 && j == cols - 1) {
            return grid[i + 1][j] == NOTHING && grid[i][j - 1] == NOTHING;
        } else if (i == rows - 1 && j == 0) {
            return grid[i - 1][j] == NOTHING && grid[i][j + 1] == NOTHING;
        } else if (i == rows - 1 && j == cols - 1) {
            return grid[i - 1][j] == NOTHING && grid[i][j - 1] == NOTHING;
        } else if (i == 0) {
            return grid[i + 1][j] == NOTHING && grid[i][j - 1] == NOTHING && grid[i][j + 1] == NOTHING;
        } else if (i == rows - 1) {
            return grid[i - 1][j] == NOTHING && grid[i][j - 1] == NOTHING && grid[i][j + 1] == NOTHING;
        } else if (j == 0) {
            return grid[i - 1][j] == NOTHING && grid[i + 1][j] == NOTHING && grid[i][j + 1] == NOTHING;
        } else if (j == cols - 1) {
            return grid[i - 1][j] == NOTHING && grid[i + 1][j] == NOTHING && grid[i][j - 1] == NOTHING;
        } else {
            return grid[i - 1][j] == NOTHING && grid[i + 1][j] == NOTHING && grid[i][j - 1] == NOTHING
                    && grid[i][j + 1] == NOTHING;
        }
    }

    private void mark(int i, int j, int identify) {
        if (hasSomething(i, j)) {
            grid[i][j] = identify;
        } else {
            return;
        }
        if (i == 0 && j == 0) {
            mark(i + 1, j, identify);
            mark(i, j + 1, identify);
        } else if (i == 0 && j == cols - 1) {
            mark(i + 1, j, identify);
            mark(i, j - 1, identify);
        } else if (i == rows - 1 && j == 0) {
            mark(i - 1, j, identify);
            mark(i, j + 1, identify);
        } else if (i == rows - 1 && j == cols - 1) {
            mark(i - 1, j, identify);
            mark(i, j - 1, identify);
        } else if (i == 0) {
            mark(i + 1, j, identify);
            mark(i, j - 1, identify);
            mark(i, j + 1, identify);
        } else if (i == rows - 1) {
            mark(i - 1, j, identify);
            mark(i, j - 1, identify);
            mark(i, j + 1, identify);
        } else if (j == 0) {
            mark(i - 1, j, identify);
            mark(i + 1, j, identify);
            mark(i, j + 1, identify);
        } else if (j == rows - 1) {
            mark(i - 1, j, identify);
            mark(i + 1, j, identify);
            mark(i, j - 1, identify);
        } else {
            mark(i - 1, j, identify);
            mark(i + 1, j, identify);
            mark(i, j - 1, identify);
            mark(i, j + 1, identify);
        }
    }
    //get alone cells
    private int countAloneCells() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasSomething(i, j) && isAlone(i, j)) {// 判断0 还是1 再判断是否为单独的一个1
                    count++;
                }
            }
        }
        return count;
    }
    //get together cells
    private int countTogetherCells() {
        reset();
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasSomething(i, j) && !isAlone(i, j)) {
                    mark(i, j, count + 2);// 对已经判断过的区块进行标识,并且不同区块标识数不同
                    count++;
                }
            }
        }
        if (defaultReset) {
            reset();
        }
        return count;
    }
    //总块数 alone + together
    public int count() {
        return countAloneCells() + countTogetherCells();
    }

    public void setDefaultReset(boolean defaultReset) {
        this.defaultReset = defaultReset;
    }

    public void reset() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    grid[i][j] = 1;
                }
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public void showGrid() {
        for (int[] is : grid) {
            for (int i : is) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
