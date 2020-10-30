import java.util.Scanner;

public class PDD1023_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
//        int[] prices = new int[N];
//        for (int i = 0; i < N; i++) {
//            prices[i] = in.nextInt();
//        }
        int lowestPri = Integer.MAX_VALUE, highestPri = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int thePri = in.nextInt();
            lowestPri = Math.min(lowestPri, thePri);
            highestPri = Math.max(highestPri, thePri);
        }
        in.close();
        int minPrice = 0, maxPrice = Integer.MAX_VALUE;
//        for (int price : prices) {
//            minPrice = Math.max(minPrice, price - M);
//            maxPrice = Math.min(maxPrice, price + M);
//        }
        minPrice = Math.max(minPrice, highestPri - M);
        maxPrice = Math.min(maxPrice, lowestPri + M);
        if (minPrice <= maxPrice) {
            System.out.println(minPrice + " " + maxPrice);
        } else {
            System.out.println(-1);
        }
    }
}
