public class LeetCode647 {
    public int countSubstrings(String s) {
        int length = s.length();
        int res = 0;
        for(int i=0;i<length;++i){
            int count = 0;
            for(int j=0;j<=i&&j<=length-1-i;++j){
                if(s.charAt(i-j)==s.charAt(i+j)){
                    count++;
                }
//                if(s.charAt(i-j)==s.charAt(i+j+1)){
//                    count++;
//                }
                else break;
            };
            for(int j=0;j<=i&&j<=length-2-i;++j){
//                if(s.charAt(i-j)==s.charAt(i+j)){
//                    count++;
//                }
                if(s.charAt(i-j)==s.charAt(i+j+1)){
                    count++;
                }
                else break;
            };
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode647 solve = new LeetCode647();
        String s = "aaa";
        System.out.println(solve.countSubstrings(s));
    }
}
