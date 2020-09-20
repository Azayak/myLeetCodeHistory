public class LeetCode60 {

    int[] res;
    int num;

    public String getPermutation(int n, int k) {
        res = new int[n + 1];
        num = n;
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        getRes(n, k, 1);
        for (int i = 1; i < res.length; i++) {
            int temp = 1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] == 0) ;
                else if (temp == res[i]) {
                    res[i] = nums[j];
                    nums[j] = 0;
                    break;
                }
                else {
                    temp++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public void getRes(int n, int k, int i) {
        if (i == num + 1) ;
        else {
            for (int j = 0; j <= n; j++) {
                if (k <= j * jiecheng(n-1)) {
                    res[i] = j;
                    break;
                }
            }
            getRes(n-1, k - (res[i]-1)*jiecheng(n-1), i+1);
        }
    }

    public int jiecheng(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode60 solve = new LeetCode60();
        System.out.println(solve.getPermutation(4,7));
    }
}
