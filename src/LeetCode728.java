import java.util.ArrayList;
import java.util.List;

public class LeetCode728 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> selfDividingNumbers(int left, int right) {
//        for (int i = left; i <= right; i++) {
//            List<Integer> everyNum = getEveryNum(i);
//            if (everyNum.size() > 0) {
//                boolean flag = true;
//                for (int j : everyNum) {
//                    if (i % j != 0) {
//                        flag = false;
//                    }
//                }
//                if (flag) {
//                    res.add(i);
//                    System.out.println(i);
//                }
//            }
//        }

        for (int i = left; i <= right; i++) {
            if (selfDividing(i)) {
                res.add(i);
                System.out.println(i);
            }
        }

        return res;
    }

//    public List<Integer> getEveryNum(int n) {
//        List<Integer> everyNum = new ArrayList<>();
//        while (n > 0) {
//            int rest = n % 10;
//            if (rest != 0) {
//                everyNum.add(rest);
//            }
//            else {
//                return new ArrayList<>();
//            }
////            System.out.println(n % 10);
//            n /= 10;
//        }
//        return everyNum;
//    }

    public boolean selfDividing(int n) {
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode728 solve = new LeetCode728();
        solve.selfDividingNumbers(1, 22);
//        solve.getEveryNum(10);
    }
}
