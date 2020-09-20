import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    static int flag = 1000000007;
    int num;
    int[] res;

    List<List<Integer>> resLists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> oneRes = new ArrayList<>();

        if (nums.length == 0) {
            return resLists;
        }
        if (nums.length == 1) {
            oneRes.add(nums[0]);
            resLists.add(oneRes);
            return resLists;
        }

        num = nums.length;
        res = new int[num + 1];

        for (int m = 1; m <= jiecheng(num); m++) {
            getRes(nums.length, m, 1);


            int[] _nums = new int[num+1];
            _nums[0] = flag;
            for (int i = 1; i < _nums.length; i++) {
                _nums[i] = nums[i-1];
            }

            for (int i = 1; i < res.length; i++) {
                int temp = 1;
                for (int j = 1; j < _nums.length; j++) {
                    if (_nums[j] == flag) ;
                    else if (temp == res[i]) {
                        res[i] = _nums[j];
                        _nums[j] = flag;
                        break;
                    }
                    else {
                        temp++;
                    }
                }
            }

            oneRes = new ArrayList<>();
            for (int i = 1; i < res.length; i++) {
                oneRes.add(res[i]);
            }
            resLists.add(oneRes);
        }
        return resLists;
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
        LeetCode46 solve = new LeetCode46();
        int[] nums = {1,2,3};
        List<List<Integer>> resLists = solve.permute(nums);

        for (List<Integer> list : resLists) {
            for (int i : list) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }
}
