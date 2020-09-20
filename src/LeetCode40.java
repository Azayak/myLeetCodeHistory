import java.util.*;

public class LeetCode40 {

//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//
//    }


//    int[] candidates;
//    int target;
//    List<List<Integer>> res = new ArrayList<>();



//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        this.candidates = candidates;
//        this.target = target;
//        getOneRes(new ArrayList<>(), 0, -1, 0);
//        return res;
//    }
//
//
//    public void getOneRes(List<Integer> oneRes, int n, int firstNum, int sum) {
//        if (sum < target) {
//            for (int i = firstNum + 1; i < candidates.length; i++) {
//                oneRes.add(candidates[i]);
//                getOneRes(oneRes,n + 1, i, sum + candidates[i]);
//                oneRes.remove(n);
//                if (i == candidates.length - 1 || candidates[i] == candidates[i + 1]) {
//                    i++;
//                }
//            }
//        }
//        else if (sum == target) {
//            List<Integer> theRes = new ArrayList<>();
//            theRes.addAll(oneRes);
//            res.add(theRes);
//        }
//    }



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, len, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode40 solve = new LeetCode40();
        int[] candidates = {10,1,2,7,6,1,5};
//        int[] candidates = {2,5,2,1,2};
        int target = 8;

        List<List<Integer>> res = solve.combinationSum2(candidates, target);

        for (List<Integer> oneRes : res) {
            for (int i : oneRes) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }

}
