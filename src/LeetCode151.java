public class LeetCode151 {

    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            res.append(strings[i]);
            if (i > 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
