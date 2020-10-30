import java.math.BigInteger;
import java.util.Scanner;

public class JianXinJinKe1024_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        BigInteger maxMultiplyRes = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        BigInteger four = new BigInteger("4");
        if (n == 2) {
            System.out.println(maxMultiplyRes);
        } else if (n == 3) {
            System.out.println(maxMultiplyRes.multiply(two));
        } else if (n == 4) {
            System.out.println(maxMultiplyRes.multiply(two).multiply(two));
        } else {
            while (n > 4) {
                maxMultiplyRes = maxMultiplyRes.multiply(three);
                n -= 3;
            }
            if (n == 2) {
                maxMultiplyRes = maxMultiplyRes.multiply(two);
            } else if (n == 3) {
                maxMultiplyRes = maxMultiplyRes.multiply(three);
            } else if (n == 4) {
                maxMultiplyRes = maxMultiplyRes.multiply(four);
            }
            System.out.println(maxMultiplyRes);
        }
    }
}
