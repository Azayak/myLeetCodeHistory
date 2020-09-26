import java.util.Deque;
import java.util.LinkedList;

public class Offer13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] record = new boolean[m][n];
        Deque<int[]> posDeque = new LinkedList<>();
        posDeque.offer(new int[]{0,0});
        record[0][0] = true;

        final int[] mx = {1,0};
        final int[] my = {0,1};
        int count = 0;
        while (!posDeque.isEmpty()) {
            int[] pos = posDeque.poll();
            int x = pos[0], y = pos[1];
            count++;
            for (int i = 0; i < 2; i++) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (nextX < m && nextY < n && !record[nextX][nextY] && isAccessible(nextX, nextY, k)) {
                    posDeque.offer(new int[]{nextX, nextY});
                    record[nextX][nextY] = true;
                }
            }
        }
        return count;
    }

    private boolean isAccessible(int i, int j, int k) {
        return (i % 10 + i / 10 + j % 10 + j / 10) <= k;
    }
}