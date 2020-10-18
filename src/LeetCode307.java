public class LeetCode307 {

//    public class NumArray {

        int[] myArray;
        int[] myArraySum;
        public LeetCode307(int[] nums) {
            int sum = 0;
            myArray = new int[nums.length];
            myArraySum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                myArray[i] = nums[i];
                myArraySum[i] = sum;
            }
        }

        public void update(int i, int val) {
            int sub = val - myArray[i];
            for (int j = i; j < myArray.length; j++) {
                myArraySum[j] += sub;
            }
            myArray[i] = val;
        }

        public int sumRange(int i, int j) {
            return myArraySum[j] - myArraySum[i] + myArray[i];
        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        LeetCode307 solve = new LeetCode307(nums);
        solve.sumRange(0,2);
        solve.update(1,2);
        solve.sumRange(0,2);
    }
}
