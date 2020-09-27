public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int row = matrix.length, col = matrix[0].length;
        int length = row * col;
        int[] res = new int[length];
        boolean[][] flag = new boolean[row][col];

        int[] mx = {0,1,0,-1};
        int[] my = {1,0,-1,0};

        int x = 0, y = 0;
        for (int i = 0, j = 0; i < length; j = (j + 1) % 4) {
            while (x + mx[j] < row && x + mx[j] >= 0 && y + my[j] < col && y + my[j] >=0 && !flag[x + mx[j]][y + my[j]]) {
                res[i++] = matrix[x][y];
                flag[x][y] = true;
                x += mx[j];
                y += my[j];
            }
            if (i == length - 1) {




                res[i++] = matrix[x][y];
                flag[x][y] = true;
            }
        }
        return res;
    }

//    public int[] spiralOrder(int[][] matrix) {
//        int row = matrix.length;
//        if (row == 0) return new int[]{};
//        int col = matrix[0].length;
//        if (col == 0) return new int[]{};
//        int length = row * col;
//        int[] res = new int[length];
//        boolean[][] flag = new boolean[row][col];
//
//        int[] mx = {0,1,0,-1};
//        int[] my = {1,0,-1,0};
//
//        int x = 0; int y = 0;
//        for (int i = 0, j = 0; i < length; j = (j + 1) % 4) {
//            while (i < length - 1 && y + 1 < col && !flag[x][y + 1]) {
//                res[i] = matrix[x][y];
//                flag[x][y] = true;
//                y++;
//                i++;
//            }
//            while (i < length - 1 && x + 1 < row && !flag[x + 1][y]) {
//                res[i] = matrix[x][y];
//                flag[x][y] = true;
//                x++;
//                i++;
//            }
//            while (i < length - 1 && y - 1 >= 0 && !flag[x][y - 1]) {
//                res[i] = matrix[x][y];
//                flag[x][y] = true;
//                y--;
//                i++;
//            }
//            while (i < length - 1 && x - 1 >= 0 && !flag[x - 1][y]) {
//                res[i] = matrix[x][y];
//                flag[x][y] = true;
//                x--;
//                i++;
//            }
//            if (i == length - 1) {
//                res[i] = matrix[x][y];
//                flag[x][y] = true;
//                i++;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Offer29 solve = new Offer29();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] res = solve.spiralOrder(matrix);
        for (int i : res) {
            System.out.print(i+"   ");
        }
        System.out.println();
    }
}
