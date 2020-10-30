public class LeetCode1024 {
    public int videoStitching(int[][] clips, int T) {
        if (T == 0) {
            return  0;
        }
        int start = 0, end = 0;
        int count = 0;
        while (start < T) {
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0] <= start) {
                    end = Math.max(end, clips[i][1]);
                }
            }
            if (end == start) {
                return -1;
            }
            count++;
            start = end;
        }
        return count;
    }
}