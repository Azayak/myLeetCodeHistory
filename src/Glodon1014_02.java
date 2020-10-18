import java.util.Scanner;

public class Glodon1014_02 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        long[] nums = new long[4];
//        for (int i = 0; i < 4; i++) {
//            nums[i] = in.nextLong();
//        }
//        in.close();
//        long average = (nums[0] + nums[1] + nums[2] + nums[3]) / 4;
//        long left = 0, right = 0;
//        for (int i = 0; i < 4; i++) {
//            long sub = nums[i] - average;
//            if (sub < 0) {
//                left -= sub;
//            } else if (sub > 0) {
//                right += sub;
//            }
//            long x = 2 * left - right;
//            if (x <= 0) {
//                System.out.println(average * 4);
//            } else {
//                System.out.println((long) (average - Math.ceil((double) x / 4)) * 4);
//            }
//        }
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long A = in.nextLong();
        long B = in.nextLong();
        long C = in.nextLong();
        long D = in.nextLong();
        in.close();
        long sum = A + B + C + D;
        long average = sum / 4;
        for (long change = average; change >= 0; change--) {
            long newSum = sum - 4 * change;
            long magicNum = 0;
            if (change - A > 0) {
                magicNum += change - A;
            }
            if (change - B > 0) {
                magicNum += change - B;
            }
            if (change - C > 0) {
                magicNum += change - C;
            }
            if (change - D > 0) {
                magicNum += change - D;
            }
            if (newSum >= magicNum) {
                System.out.println(4 * change);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}
