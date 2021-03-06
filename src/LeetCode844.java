public class LeetCode844 {

//    public boolean backspaceCompare(String S, String T) {
//        return getFinalStr(S).equals(getFinalStr(T));
//    }
//
//    public String getFinalStr(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (char ch : s.toCharArray()) {
//            if (ch != '#') {
//                sb.append(ch);
//            } else if (sb.length() > 0) {
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//        return sb.toString();
//    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
