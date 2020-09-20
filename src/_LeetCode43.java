public class _LeetCode43 {

//    public String multiply(String num1, String num2) {
//        char[] res = new char[num1.length() + num2.length()];
//        char[] num11 = num1.toCharArray();
//        char[] num22 = num2.toCharArray();
//
//
//        return String.valueOf(res);
//    }
//
//    public char[] getOneMultiply(char n1, char n2, char last) {
//        char[] res = new char[2];
//        int x = (n1 - '0') * (n2 - '0') + (last - '0');
//        res[0] = (char) (x / 10 + '0');
//        res[1] = (char) (x % 10 + '0');
//        return res;
//    }
//
//    public char[] charArrayPlus(char[] c1, char[] c2) {
//        int max = c1.length >= c2.length ? c1.length + 1 : c2.length + 1;
//        char[] res = new char[max];
//
//        int i = c1.length - 1;
//        int j = c2.length - 1;
//        int m = res.length - 1;
//        boolean flag = false;
//
//        while (i >= 0 || j >= 0) {
//            if (i >= 0 && j >= 0) {
//                int sum = flag ? ((c1[i] - '0') + (c2[j] - '0')) : ((c1[i] - '0') + (c2[j] - '0') + 1);
//                if (sum > 9) {
//                    flag = true;
//                    sum /= 10;
//                }
//                else {
//                    flag = false;
//                }
//                res[m] = (char) (sum - '0');
//                i--;
//                j--;
//                m--;
//            }
//            else if (i >= 0) {
//                int sum = flag ? (c1[i] - '0') : (c1[i] - '0')+ 1;
//                if (sum > 9) {
//                    flag = true;
//                    sum /= 10;
//                }
//                else {
//                    flag = false;
//                }
//                res[m] = (char) (sum - '0');
//                i--;
//                m--;
//            }
//            else if (j >= 0) {
//                int sum = flag ? (c2[j] - '0') : (c2[j] - '0')+ 1;
//                if (sum > 9) {
//                    flag = true;
//                    sum /= 10;
//                }
//                else {
//                    flag = false;
//                }
//                res[m] = (char) (sum - '0');
//                j--;
//                m--;
//            }
//            else {
//                break;
//            }
//        }
//        return res;
//    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

}
