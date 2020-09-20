import java.util.Stack;

public class LeetCode733 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        // Queue<int[]> queue = new LinkedList<int[]>();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr,sc});
        // queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        // while (!queue.isEmpty())
        while (!stack.isEmpty()){
            // int[] cell = queue.poll();
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    // queue.offer(new int[]{mx, my});
                    stack.push(new int[]{mx,my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
