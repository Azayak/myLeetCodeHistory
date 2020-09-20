import java.util.*;

public class MeiTuan091303 {

    int n, k ,d;
    int resCount = 0;
    Set<Map<Integer,Integer>> resSet = new HashSet<>();

    public static void main(String[] args) {
        MeiTuan091303 solve = new MeiTuan091303();
        Scanner in = new Scanner(System.in);
        solve.n = in.nextInt();
        solve.k = in.nextInt();
        solve.d = in.nextInt();
        in.close();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        solve.getRes(0, 0, map);
        solve.getTheNum();
        System.out.println(solve.resCount);
    }

    public void getRes(int num, int sum, Map<Integer, Integer> map) {
        if (num == 0) {
            for (int i = d; i <= k; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                getRes(num + 1, i, map);
                int time = map.get(i);
                map.remove(i);
                if (time > 1) {
                    map.put(i, time - 1);
                }
            }
        }else {
            if (sum == n) {
                if (!resSet.contains(map)) {
                    Map<Integer,Integer> theRes = new HashMap<>(map);
                    resSet.add(theRes);
                }
            }else if (sum < n) {
                for (int i = 1; i <= k; i++) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    getRes(num + 1, sum + i, map);
                    int time = map.get(i);
                    map.remove(i);
                    if (time > 1) {
                        map.put(i, time - 1);
                    }
                }
            }
        }
    }

    public int getTheNum() {
        for (Map<Integer,Integer> map : resSet) {
            int num = 0;
            List<Integer> list = new ArrayList<>(map.values());
            for (int i : list) {
                num += i;
            }
            int res = 1;
            for (int i = 1; i <= num; i++) {
                res *= i;
            }
            for (int i : list) {
                for (int j = 1; j <= i; j++) {
                    res /= j;
                }
            }
            resCount += res;
        }
        return resCount;
    }

}
