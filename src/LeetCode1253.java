import java.util.ArrayList;
import java.util.List;

public class LeetCode1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();

        int sum = 0;
        for (int i : colsum) {
            sum += i;
        }
        if (upper + lower != sum) return res;

        List<Integer> upList = new ArrayList<>();
        List<Integer> lowList = new ArrayList<>();
        int[] flag = new int[colsum.length];

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                upList.add(1);
                lowList.add(1);
                upper--;
                lower--;
                flag[i] = 1;
                if (upper < 0 || lower < 0) return res;
            }
            else if (colsum[i] == 0) {
                upList.add(0);
                lowList.add(0);
                flag[i] = 1;
            }
            else {
                upList.add(0);
                lowList.add(0);
            }
        }

        if (upper == 0 && lower == 0) {
            res.add(upList);
            res.add(lowList);
            return res;
        }

        for (int i = 0; i < colsum.length && upper > 0; i++) {
            if (flag[i] == 0) {
                upList.set(i,1);
                flag[i] = 1;
                upper--;
            }
        }

        for (int i = 0; i < colsum.length && lower > 0; i++) {
            if (flag[i] == 0) {
                lowList.set(i,1);
                flag[i] = 1;
                lower--;
            }
        }
        res.add(upList);
        res.add(lowList);
        return res;
    }
}
