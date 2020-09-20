import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        getOneRes(new ArrayList<>(), k, 0, 1, 0, n);
        return res;
    }

    public void getOneRes(List<Integer> oneRes, int k, int sum, int firstNum, int num, int n) {
        if (num == k) {
            if (sum == n) {
                //浅拷贝值会被修改，new新链表赋值防止数据被修改
                List<Integer> temp = new ArrayList<>();
                for (int m : oneRes) {
                    temp.add(m);
                }
                res.add(temp);
            }
        }
        else if (firstNum <= 9){
            for (int i = firstNum; i <= 9; i++) {
                oneRes.add(i);
                getOneRes(oneRes, k, sum + i, i + 1, num + 1, n);
                oneRes.remove(num);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode216 solve = new LeetCode216();
        List<List<Integer>> res = solve.combinationSum3(3, 9);

        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num +"   ");
            }
            System.out.println();
        }
    }

}
