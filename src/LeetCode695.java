public class LeetCode695 {

//    int[] mx = {-1,0,1,0};
//    int[] my = {0,-1,0,1};
//
//    boolean[][] flag;
//    int[][] grid;
//
//    public int maxAreaOfIsland(int[][] grid) {
//        int maxArea = 0;
//        this.grid = grid;
//        this.flag = new boolean[this.grid.length][this.grid[0].length];
//        for (int i = 0; i < this.grid.length; i++) {
//            for (int j = 0; j < this.grid[0].length; j++) {
//                if (this.grid[i][j] == 1 && !this.flag[i][j]) {
//                    maxArea = Math.max(maxArea, dfs(i, j));
//                }
//            }
//        }
//        return maxArea;
//    }
//
//    public int dfs(int i, int j) {
//        int area = 0;
//        Deque<int[]> pointList = new LinkedList<>();
//        pointList.push(new int[]{i, j});
//        this.flag[i][j] = true;
//
//        while (!pointList.isEmpty()) {
//            int[] thisPoint = pointList.pop();
//            int x = thisPoint[0]; int y = thisPoint[1];
//            area++;
//            for (int k = 0; k < 4; k++) {
//                int adjustX = x + mx[k];
//                int adjustY = y + my[k];
//                if (adjustX >= 0 && adjustX < this.grid.length &&
//                        adjustY >= 0 && adjustY < this.grid[0].length &&
//                        this.grid[adjustX][adjustY] == 1 && !this.flag[adjustX][adjustY]) {
//                    pointList.push(new int[]{adjustX,adjustY});
//                    this.flag[adjustX][adjustY] = true;
//                }
//            }
//        }
//        return area;
//    }

    int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        this.grid = grid;
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                if (this.grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j) {
        if (i < 0 || i >= this.grid.length || j < 0 || j >= this.grid[0].length || this.grid[i][j] == 0) {
            return 0;
        }
        int area = 1;
        this.grid[i][j] = 0;
        area += dfs(i - 1, j);
        area += dfs(i + 1, j);
        area += dfs(i, j - 1);
        area += dfs(i, j + 1);
        return area;
    }



    public static void main(String[] args) {
        LeetCode695 solve = new LeetCode695();
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(solve.maxAreaOfIsland(grid));
    }

}
