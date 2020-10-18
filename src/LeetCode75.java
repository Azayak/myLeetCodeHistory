public class LeetCode75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= left && i <= right) {
                if (nums[i] == 0) {
                    nums[i--] = nums[left];
                    nums[left++] = 0;
                }
                else if (nums[i] == 2) {
                    nums[i--] = nums[right];
                    nums[right--] = 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode75 solve = new LeetCode75();
//        int[] nums = {2,0,2,1,1,0};
        int[] nums = {1,0};
        for (int num : nums) {
            System.out.print(num + "   ");
        }
        System.out.println();
        solve.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + "   ");
        }
        System.out.println();
    }
}
