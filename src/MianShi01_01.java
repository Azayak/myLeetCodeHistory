public class MianShi01_01 {
    public boolean isUnique(String astr) {
        int temp = 0;
        for (char ch : astr.toCharArray()) {
            int index = ch - 'a';
            if ((temp & (1 << index)) != 0) {
                return false;
            }
            else {
                temp |= (1 << index);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MianShi01_01 solve = new MianShi01_01();
        String s = "leetcode";
        System.out.println(solve.isUnique(s));
    }
}