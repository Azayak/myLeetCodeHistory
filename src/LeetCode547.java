import java.util.Deque;
import java.util.LinkedList;

public class LeetCode547 {

    int N;

    public int findCircleNum(int[][] M) {
        int res = 0;
        N = M.length;
        int[] flag = new int[N];
        Deque<Integer> friendLine = new LinkedList<>();
        int pos;
        while ((pos = isEmpty(flag)) != -1) {
            res++;
            friendLine.offer(pos);
            while (!friendLine.isEmpty()) {
                int thisPos = friendLine.poll();
                flag[thisPos] = 1;
                for (int i = 0; i < N; i++) {
                    if (M[thisPos][i] == 1 && flag[i] == 0) {
                        friendLine.offer(i);
                    }
                }
            }
        }
        return res;
    }

    public int isEmpty(int[] flag) {
        for (int i = 0; i < N; i++){
            if (flag[i] == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode547 solve = new LeetCode547();
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solve.findCircleNum(M));
    }

}
