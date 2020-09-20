public class LeetCode674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int increaseLength = 1;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            increaseLength = nums[i] > nums[i - 1] ? increaseLength + 1 : 1;
            res = Math.max(res, increaseLength);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode674 solve = new LeetCode674();
        int[] nums = {1,3,5,7};
        System.out.println(solve.findLengthOfLCIS(nums));
    }
}
