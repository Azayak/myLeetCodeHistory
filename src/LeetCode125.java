/**给定一个字符串，验证它是否是回文串，只考虑
 * 字母和数字字符，可以忽略字母的大小写。*/

public class LeetCode125 {
    //双指针检测字符串两端是否匹配
    public boolean isPalindrome(String s) {
        StringBuffer SB = new StringBuffer();
        int length = s.length();
        for(int i=0;i<length;i++){
            char tmp = s.charAt(i);
            if(Character.isLetterOrDigit(tmp)){
                SB.append(Character.toLowerCase(tmp));
            }
        }
        int n = SB.length();
        int left=0;
        int right=n-1;
        while(left<right){
            if(Character.toLowerCase(SB.charAt(left)) !=
                    Character.toLowerCase(SB.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
