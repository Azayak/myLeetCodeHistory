import java.util.ArrayList;
import java.util.List;

public class LeetCode763 {

//    public List<Integer> partitionLabels(String S) {
//        List<Integer> res = new ArrayList<>();
//        int[] lastIndex = new int[26];
//        for (int i = 0; i < S.length(); i++) {
//            lastIndex[S.charAt(i) - 'a'] = i;
//        }
//        int beginIndex = 0, endIndex = 0;
//        while (beginIndex < S.length()) {
//            int theLetter = S.charAt(beginIndex) - 'a';
//            endIndex = lastIndex[theLetter];
//            for (int i = beginIndex; i < endIndex; i++) {
//                theLetter = S.charAt(i) - 'a';
//                endIndex = Math.max(lastIndex[theLetter], endIndex);
//            }
//            res.add(endIndex - beginIndex + 1);
//            beginIndex = endIndex + 1;
//        }
//        return res;
//    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int beginIndex = 0, endIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            endIndex = Math.max(lastIndex[S.charAt(i) - 'a'], endIndex);
            if (i == endIndex) {
                res.add(endIndex - beginIndex + 1);
                beginIndex = endIndex + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode763 solve = new LeetCode763();
        String S = "ababcbacadefegdehijhklij";
        List<Integer> res = solve.partitionLabels(S);
        for (int i : res) {
            System.out.print(i + "   ");
        }
    }
}
