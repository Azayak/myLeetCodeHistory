import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        getRes(nums, 0, -1, new ArrayList<>());
        return res;
    }

    public void getRes(int[] nums, int num, int lastNum, List<Integer> oneRes) {
        if (num <= nums.length) {
            res.add(new ArrayList<>(oneRes));
            for (int i = lastNum + 1; i < nums.length; i++) {
                oneRes.add(nums[i]);
                getRes(nums, num + 1, i, oneRes);
                oneRes.remove(num);
            }
        }
    }
}
