import java.util.Arrays;
import java.util.Scanner;

public class JianXinJinKe1024_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int hit = in.nextInt();
        int t = in.nextInt();
        int[] hps = new int[n];
        for (int i = 0; i < n; i++) {
            hps[i] = in.nextInt();
        }
        in.close();
        int res = 0;
        Arrays.sort(hps);
        for (int i = 0; i < n; i++) {
            hps[i] = hps[i] % hit == 0 ? hps[i] / hit : hps[i] / hit + 1;
        }
        for (int i = 0, time = t; i < n; i++) {
            if (time >= hps[i]) {
                res++;
                time -= hps[i];
            } else {
                break;
            }
        }
        System.out.println(res);
    }
}
