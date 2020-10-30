import java.util.Scanner;

public class YueWen1021_03 {
    public static void main(String[] args) {
        int[][] a = new int[110][110];
        int[][] b = new int[110][110];
        int[][] c = new int[110][110];
        Scanner sc = new Scanner(System.in);
        String mpn = sc.nextLine();
        String[] mpnss = mpn.split(",");

        int m = Integer.parseInt(mpnss[0]);
        int p = Integer.parseInt(mpnss[1]);
        int n = Integer.parseInt(mpnss[2]);
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] ss = s.split(",");
            for (int j = 0; j < p; j++) {
                a[i][j] = Integer.parseInt(ss[j]);
            }
        }
        for (int i = 0; i < p; i++) {
            String s = sc.nextLine();
            String[] ss = s.split(",");
            for (int j = 0; j < n; j++) {
                b[i][j] = Integer.parseInt(ss[j]);
            }
        }
        sc.close();
        for(int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n; j++) {
                for (int t = 0; t <= p; t++) {
                    c[i][j] += a[i][t] * b[t][j];
                }
            }
        }
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n - 1; j++) {
                System.out.print(c[i][j] + ",");
            }
            System.out.println(c[i][n - 1]);
        }
    }
}
