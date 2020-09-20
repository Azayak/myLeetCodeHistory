import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1403 {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        Arrays.sort(nums);
        int subSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (2 * subSum <= sum) {
                res.add(nums[i]);
                subSum += nums[i];
            }
            else {
                break;
            }
        }
        return res;
    }
}
