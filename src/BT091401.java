public class BT091401 {

    public static void main(String[] args) {
        int[] nums = {1,2,-1,3,-2};

//        int left = 0, right = nums.length - 1;
//        while (left + 1 < right) {
//            while (nums[left + 1] >= 0) {
//                left++;
//            }
//            while (nums[right])

        int i; int j; int temp;

        for (i = 0,j = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                temp = nums[i];
                for (int k = i; k > j; k--) {
                    nums[k] = nums[k - 1];
                }
                nums[j++] = temp;
            }
        }
        for (int num : nums) {
            System.out.print(num+"   ");
        }
        System.out.println();

    }
}
