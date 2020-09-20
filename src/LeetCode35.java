public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        //遍历数组查找
        // int length = nums.length;
        // int i = 0;
        // while(i<length){
        //     if(nums[i]==target) return i;
        //     else if(target<nums[i]) break;
        //     else i++;
        // }
        // int[] res = new int[length+1];
        // for(int j=0;j<i;j++)
        //     res[j] = nums[j];
        // res[i] = target;
        // for(int j=i+1;j<=length;j++)
        //     res[j] = nums[j-1];
        // return i;
        //**********************************
        //二分查找
        // int length = nums.length;
        // int i = length/2;
        // while(true){
        //     if(nums[i]==target) break;
        //     if((nums[i]<target)&&(nums[i+1]>target)) break;
        //     if(nums[i]>target) i = i/2;
        //     if(nums[i]<target) i = (length+i)/2;
        // }
        // return i;
        //*********************************
        //leetcode
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
