import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] flag = new boolean[rooms.size()];
        Deque<Integer> keys = new LinkedList<>();
        keys.offer(0);
        while (!keys.isEmpty()) {
            int key = keys.poll();
            if (!flag[key]) {
                flag[key] = true;
                for (int i : rooms.get(key)) {
                    keys.offer(i);
                }
            }
        }
        for (boolean i : flag) {
            if (!i) return false;
        }
        return true;
    }
}
