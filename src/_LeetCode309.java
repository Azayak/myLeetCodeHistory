public class _LeetCode309 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] oneDaysPri = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            oneDaysPri[i] = prices[i + 1] - prices[i];
        }
        int[] twoDaysPri = new int[length - 2];
        for (int i = 0; i < length - 2; i++) {
            twoDaysPri[i] = prices[i + 2] - prices[i];
        }

        return 0;
    }
}
