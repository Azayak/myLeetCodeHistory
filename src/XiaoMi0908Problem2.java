import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XiaoMi0908Problem2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
        int[] colorValue = new int[c + 1];
        int originValue = 2;
        for (int i = 1; i <= c; i++) {
            colorValue[i] = originValue;
            originValue *= 2;
        }
        int[] capColor = new int[n];
        for (int i = 0; i < n; i++) {
            int colorNum = in.nextInt();
            for (int j = 0; j < colorNum; j++) {
                capColor[i] += colorValue[in.nextInt()];
            }

            if (colorNum == 0) {
                capColor[i] = 1;
            }
        }

        boolean[] isDuplicate = new boolean[c + 1];
        int duplicateColorNum = 0;

        for (int i = 0; i < n; i++) {
            int thisCapColor = capColor[i];
            String thisCapColorDesc = new StringBuilder(Integer.toBinaryString(thisCapColor)).reverse().toString();
            for (int j = i + 1; j <= m; j++) {
                int thatCapColor = capColor[(i + j) % n];
                String thatCapColorDesc = new StringBuilder(Integer.toBinaryString(thatCapColor)).reverse().toString();
                for (int colorNum = 0; colorNum < thisCapColorDesc.length() && colorNum < thatCapColorDesc.length(); colorNum++) {
                    if (thisCapColorDesc.charAt(colorNum) == '1' && thatCapColorDesc.charAt(colorNum) == '1') {
                        isDuplicate[colorNum] = true;
                    }
                }
            }
        }
        for (boolean flag : isDuplicate) {
            if (flag) {
                duplicateColorNum++;
            }
        }
        System.out.println(duplicateColorNum);
    }
}
