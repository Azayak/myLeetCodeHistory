public class LeetCode771 {

    public int numJewelsInStones(String J, String S) {
        boolean[] judge = new boolean[52];
        for (char ch : J.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                judge[ch - 'a'] = true;
            }
            if (ch >= 'A' && ch <= 'Z') {
                judge[ch - 'A' + 26] = true;
            }
        }
        int res = 0;
        for (char ch : S.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if (judge[ch - 'a']) res++;
            }
            if (ch >= 'A' && ch <= 'Z') {
                if (judge[ch - 'A' + 26]) res++;
            }
        }
        return res;
    }
}
