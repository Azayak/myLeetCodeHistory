import java.util.Random;

public class LeetCode528 {

    int[] divide;
    int sum = 0;
    Random random = new Random();

    public LeetCode528(int[] w) {
        this.divide = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            this.sum += w[i];
            this.divide[i] = this.sum;
        }
    }

    public int pickIndex() {
        int pick = this.random.nextInt(this.sum);
        int low = 0;
        int high = this.divide.length - 1;
        while (low != high) {
            int mid = (low + high) / 2;
            if (pick >= this.divide[mid]) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        LeetCode528 solve = new LeetCode528(new int[]{3, 1});
        int res = solve.pickIndex();
        System.out.println(res);
    }
}
