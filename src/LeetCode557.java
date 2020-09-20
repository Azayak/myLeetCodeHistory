public class LeetCode557 {

    public String reverseWords(String s) {
        if (s == "") return s;
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            for (int j = 0; j < string.length(); j++) {
                sb.append(string.charAt(string.length() - j - 1));
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode557 solve = new LeetCode557();
        String s = "Let's take LeetCode contest";
        System.out.println(solve.reverseWords(s));
    }
}
