public class Offer10_1 {

//    public int fib(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        else return fib(n - 1) + fib(n - 2);
//    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
