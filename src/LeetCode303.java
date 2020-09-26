public class LeetCode303 {

    class NumArray {

        int length;
        int[] sums;

        public NumArray(int[] nums) {
            this.length = nums.length;
            if (length > 0) {
                this.sums = new int[length];
                this.sums[0] = nums[0];
                for (int i = 1; i < length; i++) {
                    this.sums[i] = this.sums[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) return sums[j];
            return sums[j] - sums[i - 1];
        }
    }
}
