import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {

    int[] candidates;
    int target;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        getOneRes(new ArrayList<>(), 0, 0, 0);
        return res;
    }

    public void getOneRes(List<Integer> oneRes, int n, int firstNum, int sum) {
        if (sum < target) {
            for (int i = firstNum; i < candidates.length; i++) {
                oneRes.add(candidates[i]);
                getOneRes(oneRes,n + 1, i, sum + candidates[i]);
                oneRes.remove(n);
            }
        }
        else if (sum == target) {
            List<Integer> theRes = new ArrayList<>();
            for (int a : oneRes) {
                theRes.add(a);
            }
            res.add(theRes);
        }
    }

    public static void main(String[] args) {
        LeetCode39 solve = new LeetCode39();
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> res = solve.combinationSum(candidates, target);

        for (List<Integer> oneRes : res) {
            for (int i : oneRes) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }


}
