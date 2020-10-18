import java.util.Scanner;

public class Glodon1014_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();
        int ptr = n - 1, rightValue = n;
        while (ptr >= 0) {
            if (nums[ptr] == rightValue) {
                ptr--;
                rightValue--;
            } else {
                while (ptr >= 0 && nums[ptr] != rightValue) {
                    ptr--;
                }
            }
        }
        System.out.println(rightValue);
    }
}

