public class Offer14_1 {

    public int cuttingRope(int n) {
        if (n == 1 || n == 2) return 1;
        if (n == 3) return 2;
        int res = 1;
        if (n % 3 == 0) {
            while (n != 0) {
                res *= 3;
                n -= 3;
            }
            return res;
        }
        else if (n % 3 == 1){
            while (n != 4) {
                res *= 3;
                n -= 3;
            }
            res *= 4;
            return res;
        }
        else {
            while (n != 2) {
                res *= 3;
                n -= 3;
            }
            res *= 2;
            return res;
        }
    }
}
