public class LeetCode70 {

    public int climbStairs(int n) {
        //组合数求解：存在问题：阶乘数过大溢出
        //     int max1 = n;
        //     int min1 = n%2;
        //     int num2;
        //     int res = 0;
        //     for(int num1=min1;num1<=max1;num1+=2){
        //         num2 = (n-num1)/2;
        //         res += pailie(num1+num2,num1);
        //     }
        //     return res%1000000007;
        // }

        // //求阶乘
        // private int jiecheng(int k){
        //     if(k==0) return 0;
        //     int res = 1;
        //     for(int i=1;i<=k;i++){
        //         res *= i;
        //     }
        //     return res;
        // }
        // //求排列数
        // private int pailie(int a,int b){
        //     int res;
        //     if(b==0||b==a) return 1;
        //     res = jiecheng(a)/(jiecheng(b)*jiecheng(a-b));
        //     return res;
        //*******************************************
        //leetcode
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }
}
