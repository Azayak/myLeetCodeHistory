import java.util.Scanner;

public class PDD1023_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        in.nextLine();
        char[] manipulates = new char[n];
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            String[] input = in.nextLine().split(" ");
            manipulates[i] = input[0].charAt(0);
            nums[i] = Long.parseLong(input[1]);
        }
        in.close();

        int[] flag = new int[3];
        long andNum = -1;
        long orNum = -1;
        long xorNum = -1;
        for (int i = 0; i < n; i++) {
            if (manipulates[i] == '&') {
                flag[0] = 1;
                if (andNum == -1) {
                    andNum = nums[i];
                } else {
                    andNum = andNum & nums[i];
                }
            } else if (manipulates[i] == '|') {
                flag[1] = 1;
                if (orNum == -1) {
                    orNum = nums[i];
                } else {
                    orNum = orNum | nums[i];
                }
            } else if (manipulates[i] == '^'){
                flag[2] = 1;
                if (xorNum == -1) {
                    xorNum = nums[i];
                } else {
                    xorNum = xorNum ^ nums[i];
                }
            }
        }
        System.out.println(flag[0] + flag[1] + flag[2]);
        if (flag[0] == 1) {
            System.out.println("& " + andNum);
        }
        if (flag[1] == 1) {
            System.out.println("| " + orNum);
        }
        if (flag[2] == 1) {
            System.out.println("^ " + xorNum);
        }
    }
}
