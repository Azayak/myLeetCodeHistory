import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _LeetCode491 {

//    public List<List<Integer>> findSubsequences(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        for(int i=0;i<nums.length-1;i++){
//            List<Integer> tempRes = new ArrayList<>();
//            tempRes.add(nums[i]);
//            for(int j=i+1;j<nums.length;j++){
//                for (int m : tempRes){
//                    System.out.print("   "+m);
//                }
//                System.out.println();
//                if(nums[j]>=tempRes.get(tempRes.size()-1)){
//                    tempRes.add(nums[j]);
//                    res.add(tempRes);
//                }
//            }
//        }
//
//        return res;
//    }
//
//    public static void main(String[] args) {
//        _LeetCode491 solve = new _LeetCode491();
////        int[] nums = {4,6,7,7};
//        int[] nums = {4,6,7};
//        List<List<Integer>> res = solve.findSubsequences(nums);
//        System.out.println("**********************************");
//        for(List<Integer> list : res){
//            for (int i : list){
//                System.out.print("   "+i);
//            }
//            System.out.println();
//        }
//    }




    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Set<Integer> set = new HashSet<Integer>();
    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) 1E9 + 7);
            if (check() && !set.contains(hashValue)) {
                ans.add(new ArrayList<Integer>(temp));
                set.add(hashValue);
            }
        }
        return ans;
    }

    public void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; ++i) {
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    public int getHash(int base, int mod) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public boolean check() {
        for (int i = 1; i < temp.size(); ++i) {
            if (temp.get(i) < temp.get(i - 1)) {
                return false;
            }
        }
        return temp.size() >= 2;
    }

}
