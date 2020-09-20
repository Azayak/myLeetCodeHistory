import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1386 {
    /**
     * 超出内存限制
     */
//    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//        int[][] seats = {{2,3,4,5},{4,5,6,7},{6,7,8,9}};
//        boolean[][] seatMap = new boolean[n][3];
//        for (int[] reservedSeat : reservedSeats) {
//            int row = reservedSeat[0];
//            int rank = reservedSeat[1];
//            if (isInArray(seats[0], rank)) seatMap[row-1][0] = true;
//            if (isInArray(seats[1], rank)) seatMap[row-1][1] = true;
//            if (isInArray(seats[2], rank)) seatMap[row-1][2] = true;
//        }
//        return computeRes(seatMap);
//    }
//
//    public boolean isInArray(int[] seat,int rank){
//        for(int i : seat){
//            if(rank == i) return true;
//        }
//        return false;
//    }
//
//    public int computeRes(boolean[][] seatMap){
//        int res = 0;
//        for(boolean[] row : seatMap){
//            if (!row[0] && !row[2]) res += 2;
//            else if (!row[0] || !row[2]) res++;
//            else if (!row[1]) res++;
//        }
//        return res;
//    }



    private boolean isOk(int l, int r, Set<Integer> colSet) {
        for (int i = l; i <= r; i++) {
            if (colSet.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }
            map.get(row).add(col);
        }

        int ans = 2 * n;
        for (Integer row : map.keySet()) {
            Set<Integer> colSet = map.get(row);
            int count = 0;
            if (isOk(2, 5, colSet)) {
                count++;
                if (isOk(6, 9, colSet)) {
                    count++;
                }
            } else {
                if (isOk(4, 7, colSet)) {
                    count++;
                } else {
                    if (isOk(6, 9, colSet)) {
                        count++;
                    }
                }
            }

            int diff = 2 - count;
            ans -= diff;
        }

        return ans;
    }
}
