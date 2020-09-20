import java.util.*;

public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        for (int[] i : intervals) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            int[] thisInt = list.get(i);
            int[] nextInt = list.get(i + 1);
            if (thisInt[1] >= nextInt[0]) {
                int[] newInt = {thisInt[0], Math.max(thisInt[1], nextInt[1])};
                list.remove(i);
                list.remove(i);
                list.add(i, newInt);
                i--;
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            res[i][0] = temp[0];
            res[i][1] = temp[1];
            System.out.println(temp[0] +"  " +temp[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode56 solve = new LeetCode56();
//        int[][] ints = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ints = {{1,4}};
        solve.merge(ints);
    }
}
