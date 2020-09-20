public class LeetCode1556 {

//    public String thousandSeparator(int n) {
//        if (n == 0) return "0";
//        StringBuilder sb = new StringBuilder();
//        if (n < 0) {
//            sb.append('-');
//            n = -n;
//        }
//        int num = n;
//        int length = 0;
//        while (num != 0) {
//            num /= 10;
//            length++;
//        }
//        for (int i = 0; i < length; i++) {
//            sb.append(n / (int) Math.pow(10,length - i - 1));
//            n = n % (int) Math.pow(10,length - i - 1);
//            if ((length - i) % 3 == 1 && i != length - 1)
//                sb.append('.');
//        }
//        return sb.toString();
//    }

    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        String s = String.valueOf(n);
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            if ((s.length() - i) % 3 == 0 && i != 0)
                sb.append('.');
        }
        if (flag) sb.append('-');
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode1556 solve = new LeetCode1556();
        int n = -123456789;
        System.out.println(solve.thousandSeparator(n));
    }
}
