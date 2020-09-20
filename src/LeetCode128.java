import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            }
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int thisNum = num;
                int temp = 1;
                while (set.contains(thisNum + 1)) {
                    thisNum++;
                    temp++;
                }
                res = Math.max(temp, res);
            }
        }
        return res;
    }

//    public int longestConsecutive(int[] nums) {
//        Set<Integer> num_set = new HashSet<Integer>();
//        for (int num : nums) {
//            num_set.add(num);
//        }
//
//        int longestStreak = 0;
//
//        for (int num : num_set) {
//            if (!num_set.contains(num - 1)) {
//                int currentNum = num;
//                int currentStreak = 1;
//
//                while (num_set.contains(currentNum + 1)) {
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//
//                longestStreak = Math.max(longestStreak, currentStreak);
//            }
//        }
//
//        return longestStreak;
//    }
}
