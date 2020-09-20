import java.util.*;

public class LeetCode51 {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] board = new int[n];
        place(0, board);
        return res;
    }

    private void place(int row, int[] board) {
        if (row == board.length) {
            res.add(arrayToList(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isPlace(board, row, col)){
                board[row] = col;
                place(row+1, board);
            }
        }
    }

    private boolean isPlace(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private List<String> arrayToList(int[] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (j != board[i]) temp.append('.');
                else temp.append('Q');
            }
            list.add(temp.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode51 solve = new LeetCode51();
        List<List<String>> res = solve.solveNQueens(4);
        for (List<String> row : res) {
            for (String s : row) {
                System.out.print(s + "   ");
            }
            System.out.println();
        }
    }
}
