public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        //移界类动态规划求解（出现错误）
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if((l1+l2)!=l3) return false;

        boolean[][] res = new boolean[l1+1][l2+1];

        res[0][0] = true;

        for(int i=0;i<=l1;++i){
            for(int j=0;j<=l2;++j){
                if(i>0&&j>0)
                    if((s1.charAt(i-1)!=s3.charAt(i+j-1))&&(s2.charAt(j-1)!=s3.charAt(i+j-1))){
                        res[i][j] = false;
                        continue;
                    }
                if(i>0){
                    res[i][j] = res[i][j] || (res[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)));
                }
                if(j>0){
                    res[i][j] = res[i][j] || (res[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
                }
            }
        }
        return res[l1][l2];
    }
}
