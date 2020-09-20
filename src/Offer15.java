public class Offer15 {
    // you need to treat n as an unsigned value
    //暴力求解法
    // public int hammingWeight(int n) {
    //     int res = 0;
    //     int i = maxint(n);
    //     while(n!=0){
    //         if((n-i)>=0){
    //             n -= i;
    //             i /= 2;
    //             res++;
    //         }
    //         else{
    //             i /= 2;
    //         }
    //     }
    //     return res;
    // }

    // private int maxint(int n){
    //     int res = 1;
    //     while(res<=n){
    //         res *= 2;
    //     }
    //     return res;
    // }

    // you need to treat n as an unsigned value
    //按位异或
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
