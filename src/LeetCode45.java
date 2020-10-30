
public class LeetCode45 {
    public int jump(int [] nums) {
        int length = nums.length;

        int minStep = 0;
        int curPos = 0;
        while (curPos < length - 1) {
            int maxNextPos = curPos + nums[curPos];
            if (maxNextPos >= length - 1) {
                return minStep + 1;
            }
            int maxAvaPos = maxNextPos;
            for (int i = curPos; i < length && i <= maxNextPos; i++) {
                if (maxAvaPos < i + nums[i]) {
                    maxAvaPos = i + nums[i];
                    curPos = i;
                }
            }
            minStep++;
        }
        return minStep;
    }
    public int _jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
