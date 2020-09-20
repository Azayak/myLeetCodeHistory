public class LeetCode495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = timeSeries.length * duration;
        for(int i=1;i<timeSeries.length;i++){
            res -= (timeSeries[i]-timeSeries[i-1])>=duration?0:(duration-(timeSeries[i]-timeSeries[i-1]));
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode495 solve = new LeetCode495();
        int[] timeSeries = {1,2};
        int duration = 2;
        System.out.println(solve.findPoisonedDuration(timeSeries,duration));
    }
}
