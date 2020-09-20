public class LeetCode567 {

//    public boolean checkInclusion(String s1, String s2) {
//        if (s2.length() < s1.length()) return false;
//        int[] count = new int[26];
//        for (char c : s1.toCharArray()) {
//            count[c - 'a']++;
//        }
//        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
//            int[] count1 = new int[26];
//            for (int j = i; j < i + s1.length(); j++) {
//                count1[s2.charAt(j) - 'a']++;
//            }
//            for (int m = 0; m < 26; m++) {
//                if (count[m] != count1[m]) {
//                    break;
//                }
//                if (m == 25) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    //滑动窗口
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int[] count1 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            count1[s2.charAt(i) - 'a']++;
            if (i >= s1.length() - 1) {
                if (i >= s1.length()){
                    count1[s2.charAt(i - s1.length()) - 'a']--;
                }
                for (int m = 0; m < 26; m++) {
                    if (count[m] != count1[m]) {
                        break;
                    }
                    if (m == 25) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode567 solve = new LeetCode567();
        String s1 = "ab";
        String s2 = "eidbcaooo";
        System.out.println(solve.checkInclusion(s1, s2));
    }
}
