public class _LeetCode239 {

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int length = nums.length;
//        int[] res = new int[length - k + 1];
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < k; i++) {
//            max = Math.max(max, nums[i]);
//        }
//        for (int i = k; i < nums.length; i++) {
//            sum += nums[i] - nums[i - k];
//            max = Math.max(max, sum);
//        }
//
//        return res;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[length];
        left[0] = nums[0];
        int[] right = new int[length];
        right[length - 1] = nums[length - 1];

        for (int i = 1; i < length; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = length - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int [] output = new int[length - k + 1];
        for (int i = 0; i < length - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }

}
