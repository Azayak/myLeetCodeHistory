public class LeetCode1252 {

    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int sum = 0;
        int rowNum = 0;
        for (int row : rows) {
            if(row % 2 == 1){
                sum += m;
                rowNum++;
            }
        }
        for (int col : cols) {
            if(col % 2 == 1) {
                sum += n - 2 * rowNum;
            }
        }
        return sum;
    }
}
