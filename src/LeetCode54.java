import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int length = row * col;
        List<Integer> res = new ArrayList<>();
        boolean[][] flag = new boolean[row][col];

        int[] mx = {0,1,0,-1};
        int[] my = {1,0,-1,0};

        int x = 0, y = 0;
        for (int i = 0, j = 0; i < length; j = (j + 1) % 4) {
            while (x + mx[j] < row && x + mx[j] >= 0 && y + my[j] < col && y + my[j] >=0 && !flag[x + mx[j]][y + my[j]]) {
                res.add(matrix[x][y]);
                i++;
                flag[x][y] = true;
                x += mx[j];
                y += my[j];
            }
            if (i == length - 1) {
                res.add(matrix[x][y]);
                i++;
                flag[x][y] = true;
            }
        }
        return res;
    }
}
