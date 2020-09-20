import java.util.*;

public class LeetCode47 {

//    List<List<Integer>> res = new ArrayList<>();
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        int length = nums.length;
//        if (length == 0) return res;
//        dfs(nums, 0, new ArrayList<>());
//        return res;
//    }
//
//    public void dfs (int[] nums, int index, List<Integer> thisList) {
//        if (index == nums.length) {
//            if (!res.contains(thisList)) {
//                res.add(new ArrayList<>(thisList));
//            }
//        }
//        else {
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == Integer.MAX_VALUE) {
//                    continue;
//                }
//                else {
//                    int temp = nums[i];
//                    thisList.add(nums[i]);
//                    nums[i] = Integer.MAX_VALUE;
//                    dfs(nums, index + 1, thisList);
//                    thisList.remove(index);
//                    nums[i] = temp;
//                }
//            }
//        }
//    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        if (length == 0) return res;
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> thisList) {
        if (index == nums.length) {
            res.add(new ArrayList<>(thisList));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == Integer.MAX_VALUE || (i > 0 && nums[i] == nums[i - 1])) {
                    continue;
                }
                else {
                    int temp = nums[i];
                    thisList.add(nums[i]);
                    nums[i] = Integer.MAX_VALUE;
                    dfs(nums, index + 1, thisList);
                    thisList.remove(index);
                    nums[i] = temp;
                }
            }
        }
    }
}


