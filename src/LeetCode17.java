import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0) return res;

        Map<Character,String> numToLetter = new HashMap<>() {{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};

        getRes(res,numToLetter,digits,0,new StringBuffer());
        return res;
    }



    public void getRes(List<String> res, Map<Character,String> numToLetter, String digits, int index, StringBuffer sb){
        if(index == digits.length()) {
            res.add(sb.toString());
        }
        else {
            char digit = digits.charAt(index);
            String letters = numToLetter.get(digit);
            int count = letters.length();

            for(int i = 0; i < count; i++) {
                sb.append(letters.charAt(i));
                getRes(res,numToLetter,digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
