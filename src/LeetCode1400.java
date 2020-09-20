public class LeetCode1400 {
    public boolean canConstruct(String s, int k) {
        int max = s.length();
        int min = 0;
        if(k>max) return false;
        if(k==max) return true;
        int[] temp = new int[26];
        for(char x:s.toCharArray())
            temp[x-'a']++;
        for(int i=0;i<26;++i)
            if((temp[i]&1)==1) min++;
        if(k>=min) return true;
        else return false;
    }
}
