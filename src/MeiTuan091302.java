import java.util.Scanner;

public class MeiTuan091302 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] s = s1.split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        String s2 = sc.nextLine();
        String[] s3 = s2.split(" ");
        int[] arr = new int[s3.length];
        for (int i = 0; i < s3.length; i++) {
            arr[i] = Integer.parseInt(s3[i]);
        }

        int ans = helper(n, m, k, arr);

        System.out.println(ans);
    }

    public static int helper(int n, int m, int k, int[] arr) {
        int ans = 0;
        for (int i = 0; i < n - m + 1; i++) {
            if (arr[i] >= k) {
                int j;
                for (j = 0; j < m; j++) {
                    if (arr[i + j] < k) {
                        break;
                    }
                }
                if (j == m) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
