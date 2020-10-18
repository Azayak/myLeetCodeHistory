public class LeetCode458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie + 1;
        int res = (int) Math.ceil(Math.log(buckets) / Math.log(n));
        return res;
    }
//    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
//        int states = minutesToTest / minutesToDie + 1;
//        return (int) Math.ceil(Math.log(buckets) / Math.log(states));
//    }


    public static void main(String[] args) {
        LeetCode458 solve = new LeetCode458();
        System.out.println(solve.poorPigs(1000, 15, 60));
//        System.out.println(Math.pow(1000, (double)1 / (double)4));
    }
}
