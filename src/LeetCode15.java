import java.util.*;

public class LeetCode15 {

//    int[] nums;
//    List<List<Integer>> res = new ArrayList<>();
//    Set<Set<Integer>> sameSet = new HashSet<>();
//
//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3) return res;
//        this.nums = nums;
//        getOneRes(new int[3], 0, 0, 0);
//        return res;
//    }
//
//    public void getOneRes(int[] oneRes, int n, int firstNum, int sum) {
//        if (n == 3 && sum == 0) {
//            Set<Integer> oneResSet = new HashSet<>();
//            oneResSet.add(oneRes[0]);oneResSet.add(oneRes[1]);oneResSet.add(oneRes[2]);
//            if (!sameSet.contains(oneResSet)) {
//                sameSet.add(oneResSet);
//                List<Integer> theRes = new ArrayList<>();
//                theRes.add(oneRes[0]);
//                theRes.add(oneRes[1]);
//                theRes.add(oneRes[2]);
//                res.add(theRes);
//            }
//        }
//        else if (n < 3 && firstNum < nums.length + n - 2) {
//            for (int i = firstNum; i < nums.length; i++) {
//                oneRes[n] = nums[i];
//                getOneRes(oneRes, n + 1, i + 1, sum + nums[i]);
//            }
//        }
//    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode15 solve = new LeetCode15();
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0};
//        int[] nums = {-1,0,1};
        List<List<Integer>> res = solve.threeSum(nums);

        for (List<Integer> oneRes : res) {
            for (int i : oneRes) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }

}
