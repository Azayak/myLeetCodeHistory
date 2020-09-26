import java.util.*;

public class test {
//    public static void main(String[] args) {
////        boolean[] res = new boolean[2];
////        System.out.println(res[0]);
//
////        int n = 2;
////        char letter = (char) (n + 'a');
////        System.out.println(letter);
//
////        int data = 8;
////        String binaryStr = java.lang.Integer.toBinaryString(data);
////        System.out.println("the result is : " + binaryStr);
//
//        System.out.println(fun2(2021) % 4);
//    }
//
//
//    public static int fun1() {
//        int[] nums = new int[2022];
//        nums[0] = 0;
//        nums[1] = 1;
//        for (int j = 2; j <= 2021; j++) {
//            nums[j] = (nums[j - 1] + 2 * nums[j - 1]) & 0xffff;
//        }
//        System.out.println(nums[2021]);
//        return nums[2021];
////        return i < 2 ? i : (fun1(i - 1) + 2 * fun1(i - 2)) & 0xffff;
//    }
//
//    public static int fun2(int i) {
//        return 2021 + fun1()^0x2021;
//    }


//    public static void main(String[] args) {
//        String s = "do 123";
//        String[] strings = s.split(" ");
//        String keyword = strings[0];
//        int num = Integer.parseInt(strings[1]);
//        System.out.println(keyword + "    " + num);
//    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }


}
