import java.util.Scanner;

public class XIeCheng1013_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int x = in.nextInt();
        in.close();
        int res = 0;
        while (m > 0) {
            int sum = 0;
            while (sum < x) {
                if (c > 0) {
                    sum += 100;
                    res++;
                    c--;
                } else if (b > 0) {
                    sum += 50;
                    res++;
                    b--;
                } else if (a > 0) {
                    sum += 10;
                    res++;
                    a--;
                }
            }
            int change = sum - x;
            while (change > 0) {
                if (change >= 100) {
                    change -= 100;
                    c++;
                }
                else if (change >= 50) {
                    change -= 50;
                    b++;
                }
                else if (change >= 10) {
                    change -= 10;
                    a++;
                }
            }
            m--;
        }
        System.out.println(res);
    }
}
