public class LeetCode215 {

    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int length = this.nums.length;
        int left = 0;
        int right = length - 1;
        while (true) {
            int pos = myPartition(left, right);
            if (pos == k) return this.nums[length - pos];
            else if (pos > k) {
                left = length - pos + 1;
            }
            else if (pos < k) {
                right = length - pos - 1;
            }
        }
    }

    public int myPartition(int left, int right) {
        int q = nums[left];
        int i = left;
        int j = right + 1;
        while (i < j) {
            while ( i + 1 <= right && nums[i + 1] <= q) i++;
            while (j - 1 >= left && nums[j - 1] > q) j--;
            if (i + 1 < j) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[j - 1];
                nums[j - 1] = temp;
            }
            else break;
        }
        nums[left] = nums[i];
        nums[i] = q;
        return nums.length - i;
    }

    public static void main(String[] args) {
        LeetCode215 solve = new LeetCode215();
//        int[] nums = {7,2,3,8,9,4,5};
//        int[] nums = {2,3,4,6,9,8,10,12,11};
//        int[] nums = {4,2,3,1,2,3,5,5,6};
//        int[] nums = {3,2,1,5,6,4};
//        int[] nums = {3,2,3,1,2,4,5,5,6};
        int[] nums = {1};

        System.out.println(solve.findKthLargest(nums, 1));

//        solve.nums = nums;
//        System.out.println(solve.myPartition(0,8));
//        for (int i : solve.nums) {
//            System.out.print(i + "   ");
//        }
//        System.out.println();
    }



}
