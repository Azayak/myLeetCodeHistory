public class LeetCode875 {

    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        int min = 1;
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        while (min < max) {
            int mid = (max + min) / 2;
            if (!isOK(piles, H, mid)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private boolean isOK(int[] piles, int H, int K) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile - 1) / K + 1;
        }
        return sum <= H;
    }
}
