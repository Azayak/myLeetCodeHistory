import java.util.ArrayList;
import java.util.List;

public class LeetCode1002 {

    public List<String> commonChars(String[] A) {
        int[] allCount = new int[26];
        for (int i = 0; i < A.length; i++) {
            int[] oneCount = new int[26];
            if (i == 0) {
                for (char c : A[i].toCharArray()) {
                    allCount[c - 'a']++;
                }
            }else {
                for (char c : A[i].toCharArray()) {
                    oneCount[c - 'a']++;
                }
                for (int j = 0; j < 26; j++) {
                    allCount[j] = Math.min(allCount[j], oneCount[j]);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < allCount[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 3;
        String s = String.valueOf((char) (num + 'a'));
        System.out.println(s);
    }
}
