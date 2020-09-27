import java.util.Scanner;

public class WANGYI20200927 {

    public static int[][] spiralOrder(int N) {
        int length = N * N;
        int[] res = new int[length];
        boolean[][] flag = new boolean[N][N];
        int[][] resM = new int[N][N];

        int x = 0; int y = 0;
        boolean turn = true;

        for (int i = 0; i < length; ) {
            if (turn) {
                while (i < length - 1 && y < N && !flag[x][y]) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    y++;
                    i++;
                }
                x++;
                y--;
                while (i < length - 1 && x < N && !flag[x][y]) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    x++;
                    i++;
                }
                x--;
                y--;
                while (i < length - 1 && y >= 0 && !flag[x][y]) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    y--;
                    i++;
                }
                x--;
                y++;
                while (i < length - 1 && x >= 0 && !flag[x][y]) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    x--;
                    i++;
                }
                x++;
                y++;
                if (i == length - 1) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    i++;
                }
                turn = false;
            }
            else  {
                while (i < length - 1 && x < N && !flag[x][y]) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    x++;
                    i++;
                }
                x--;
                y++;
                while (i < length - 1 && y < N && !flag[x][y]) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    y++;
                    i++;
                }
                x--;
                y--;
                while (i < length - 1 && x >= 0 && !flag[x][y]) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    x--;
                    i++;
                }
                x++;
                y--;
                while (i < length - 1 && y >= 0 && !flag[x][y]) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    y--;
                    i++;
                }
                x++;
                y++;
                if (i == length - 1) {
                    resM[x][y] = i + 1;
                    flag[x][y] = true;
                    i++;
                }
                turn = true;
            }
        }
        return resM;
    }

    public static void main(String[] args) {
//        System.out.println(spiralOrder(7, 2, 0));
//        System.out.println(spiralOrder(7, 4, 4));
//        System.out.println(spiralOrder(7, 1, 2));
//        System.out.println(spiralOrder(7));


        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int k = 0; k < c; k++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] res = spiralOrder(N);
            for (int i = 0; i < M; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                System.out.println(res[x][y]);
            }
        }
    }
}

 class Main {

    public static int spiralOrder(int N, int a, int b) {
        int length = N * N;
        int[] res = new int[length];
        boolean[][] flag = new boolean[N][N];


        int x = 0; int y = 0;
        boolean turn = true;

        for (int i = 0; i < length; ) {
            if (turn) {
//                x++;
                while (i < length - 1 && y < N && !flag[x][y]) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    y++;
                    i++;
                }
                x++;
                y--;
                while (i < length - 1 && x < N && !flag[x][y]) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    x++;
                    i++;
                }
                x--;
                y--;
                while (i < length - 1 && y >= 0 && !flag[x][y]) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    y--;
                    i++;
                }
                x--;
                y++;
                while (i < length - 1 && x >= 0 && !flag[x][y]) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    x--;
                    i++;
                }
                x++;
                y++;
                if (i == length - 1) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    i++;
                }
                turn = false;
            }
            else  {
//                y++;
                while (i < length - 1 && x < N && !flag[x][y]) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    x++;
                    i++;
                }
                x--;
                y++;
                while (i < length - 1 && y < N && !flag[x][y]) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    y++;
                    i++;
                }
                x--;
                y--;
                while (i < length - 1 && x >= 0 && !flag[x][y]) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    x--;
                    i++;
                }
                x++;
                y--;
                while (i < length - 1 && y >= 0 && !flag[x][y]) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    y--;
                    i++;
                }
                x++;
                y++;
                if (i == length - 1) {
                    if (x == a && y == b) {
                        return i + 1;
                    }
                    flag[x][y] = true;
                    i++;
                }
                turn = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(spiralOrder(7, 2, 0));
//        System.out.println(spiralOrder(7, 4, 4));
//        System.out.println(spiralOrder(7, 1, 2));
//        System.out.println(spiralOrder(7, 3, 3));


        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int k = 0; k < c; k++) {
            int N = in.nextInt();
            int M = in.nextInt();
            for (int i = 0; i < M; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                System.out.println(spiralOrder(N, x, y));
            }
        }
    }


}