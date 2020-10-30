import java.util.Scanner;

public class PDD1023_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        in.close();
        int[][] count = new int[26][2];
        for (int i = 0; i < 26; i++) {
            count[i][0] = -1;
            count[i][1] = S.length();
        }
        for (int i = 0; i < S.length(); i++) {
            int theLetter = S.charAt(i) - 'a';
            if (count[theLetter][0] == -1) {
                count[theLetter][0] = i;
            }
            count[theLetter][1] = i;
        }
        int start = S.length() - 1, end = 0;
        int preStart = S.length() - 1;
        for (int i = 0; i < 26; i++) {
            int[] oneLetter = count[i];
            if (oneLetter[1] != S.length()) {
                if (start == S.length() - 1) {
                    if (oneLetter[1] < start) {
                        start = Math.min(start, oneLetter[1]);
                        preStart = oneLetter[0];
                    }
                } else {
                    if (oneLetter[1] < start) {
                        if (oneLetter[1] > preStart) {
                            start = preStart;
                        } else {
                            start = Math.min(start, oneLetter[1]);
                            preStart = oneLetter[0];
                        }
                    }
                }
            }
            if (oneLetter[0] != -1) {
                end = Math.max(end, oneLetter[0]);
            }
        }
        int length = end - start + 1;
        System.out.println(start + " " + length);
    }
}
