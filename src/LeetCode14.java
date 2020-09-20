public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        StringBuilder stringBuilder = new StringBuilder();

        int minLength = strs[0].length();
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }

        no1:for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length; j++) {
                String s = strs[j];
                char firstChar = strs[0].charAt(i);
                if (s.charAt(i) != firstChar) {
                    break no1;
                }
                else if (j == strs.length - 1) {
                    stringBuilder.append(firstChar);
                }
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        LeetCode14 solve = new LeetCode14();
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"a","a","a"};
        System.out.println(solve.longestCommonPrefix(strs));
//        char c1 = 'f';
//        char c2 = 'f';
//        System.out.println(c1 == c2);
    }
}
