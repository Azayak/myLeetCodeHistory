public class LeetCode1275 {

    private static int X = 1;
    private static int O = 2;
    private static int A_Win = 3;
    private static int B_Win = 4;
    private static int no_Win = 5;
    private boolean turn = true;
    private int[][] board = new int[3][3];

    public String tictactoe(int[][] moves) {
        int length = moves.length;
        if (length == 0) return "Pending";
        for (int[] move : moves) {
            int res = isFinish(move);
            if (res == B_Win) return "B";
            if (res == A_Win) return "A";
        }
        if (length == 9) return "Draw";
        return "Pending";
    }

    public int isFinish(int[] move) {
        int x = move[0];
        int y = move[1];

        if (turn) board[x][y] = X;
        else board[x][y] = O;
        turn = !turn;

        if (board[x][0] == board[x][1] && board[x][1] == board[x][2]) return turn ? B_Win : A_Win;
        if (board[0][y] == board[1][y] && board[1][y] == board[2][y]) return turn ? B_Win : A_Win;
        if ((x == 0 || x == 2) && (y == 0 || y == 2)) {
            if (board[x][y] == board[1][1] && board[1][1] == board[2 - x][2 - y]) return turn ? B_Win : A_Win;
        }
        if (x == 1 && y == 1) {
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) return turn ? B_Win : A_Win;
        }
        return no_Win;
    }

    public static void main(String[] args) {
        LeetCode1275 solve = new LeetCode1275();
//        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
//        int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        int[][] moves = {{0,2},{1,0},{2,2},{1,2},{2,0},{0,0},{0,1},{2,1},{1,1}};
        System.out.println(solve.tictactoe(moves));
    }
}
