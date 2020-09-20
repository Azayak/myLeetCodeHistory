public class LeetCode541 {

    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (index + k < s.length()) {
                for (int i = 0; i < k; i++) {
                    stringBuilder.append(s.charAt(index + k - i - 1));
                }
                index += k;
            }else {
                for (int i = s.length() - 1; i >= index; i--) {
                    stringBuilder.append(s.charAt(i));
                }
                index = s.length();
            }
            if (index + k < s.length()) {
                for (int i = 0; i < k; i++) {
                    stringBuilder.append(s.charAt(index + i));
                }
                index += k;
            }else {
                for (int i = index; i < s.length(); i++) {
                    stringBuilder.append(s.charAt(i));
                }
                index = s.length();
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode541 solve = new LeetCode541();
        String s = "abcdefg";
        int k = 3;
        System.out.println(solve.reverseStr(s, k));
    }
}
