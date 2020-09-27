public class Offer16 {

//    public double myPow(double x, int n) {
//        double res = 1;
//        if (n > 0) {
//            while (n > 0) {
//                res *= x;
//                n--;
//            }
//        }
//        else if (n < 0) {
//            while (n < 0) {
//                res /= x;
//                n++;
//            }
//        }
//        return res;
//    }

    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
