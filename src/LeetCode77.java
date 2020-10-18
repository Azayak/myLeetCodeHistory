import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class

LeetCode77 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return res;
        }
        dfs(n, k, 1);
        return res;
    }

    private void dfs(int n, int k, int begin) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1);
            path.removeLast();
        }
    }
}
