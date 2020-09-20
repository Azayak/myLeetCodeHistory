public class LeetCode214 {
    public String shortestPalindrome(String s) {
        int length = s.length();
        if (length == 0 || length ==1) return s;
        int center = 0;
        boolean flag = false;
        for (int i = length / 2; i >= 0; i--) {
            int j = 1;
            while (i - j >= 0 && i + j <= length - 1) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    j++;
                    flag = false;
                }
                else {
                    j = 1;
                    break;
                }
            }
            while (i - j >= 0 && i + j -1 <= length - 1) {
                if (s.charAt(i - j) == s.charAt(i + j -1)) {
                    j++;
                    flag = true;
                }
                else {
                    j = 1;
                    break;
                }
            }
            if (i - j < 0) {
                center = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (center != 0) {
            if (flag) {
                for (int i = length - 1; i >= center; i--) {
                    sb.append(s.charAt(i));
                }
                for (int i = center; i < length; i++) {
                    sb.append(s.charAt(i));
                }
            }
            else {
                for (int i = length - 1; i >= center; i--) {
                    sb.append(s.charAt(i));
                }
                for (int i = center + 1; i < length; i++) {
                    sb.append(s.charAt(i));
                }
            }
        }
        else {
            for (int i = length - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            for (int i = 1; i < length; i++) {
                sb.append(s.charAt(i));
            }
        }
        String res = sb.toString();
        return res;
    }

    public static void main(String[] args) {
        LeetCode214 solve = new LeetCode214();
        String s = "123";
        System.out.println(solve.shortestPalindrome(s));
    }
}
