public class Offer47 {

    public int maxValue(int[][] grid) {
        //动态规划
        int m = grid.length;
        int n = grid[0].length;

        if(m==1&&n==1) return grid[0][0];

        int[][] max = new int[m][n];

        max[m-1][n-1] = grid[m-1][n-1];

        if(m==1){
            for(int i=n-2;i>=0;--i)
                max[m-1][i] = max[m-1][i+1] + grid[m-1][i];
            return max[0][0];
        }
        if(n==1){
            for(int i=n-2;i>=0;--i)
                max[i][n-1] = max[i+1][n-1] + grid[i][n-1];
            return max[0][0];
        }

        for(int i=m-2;i>=0;--i)
            max[i][n-1] = max[i+1][n-1] + grid[i][n-1];
        for(int i=n-2;i>=0;--i)
            max[m-1][i] = max[m-1][i+1] + grid[m-1][i];
        if(m==1 || n==1) return max[0][0];

        for(int i=m-2;i>=0;--i)
            for(int j=n-2;j>=0;--j){
                if(max[i+1][j]>=max[i][j+1]) max[i][j] = max[i+1][j] + grid[i][j];
                else max[i][j] = max[i][j+1] + grid[i][j];
            }

        return max[0][0];
    }
}
