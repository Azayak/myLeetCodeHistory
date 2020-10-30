public class LeetCode845 {

//    public int longestMountain(int[] A) {
//        int n = A.length;
//        if (n == 0) {
//            return 0;
//        }
//        int[] left = new int[n];
//        for (int i = 1; i < n; ++i) {
//            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
//        }
//        int[] right = new int[n];
//        for (int i = n - 2; i >= 0; --i) {
//            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
//        }
//
//        int ans = 0;
//        for (int i = 0; i < n; ++i) {
//            if (left[i] > 0 && right[i] > 0) {
//                ans = Math.max(ans, left[i] + right[i] + 1);
//            }
//        }
//        return ans;
//    }


    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int begin = -1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (A[i - 1] < A[i]) {
                if (i == 1 || A[i - 2] >= A[i - 1]) {
                    begin = i - 1;
                }
            } else if (A[i - 1] > A[i]) {
                if (begin != -1) {
                    ans = Math.max(ans, i - begin + 1);
                }
            } else {
                begin = -1;
            }
        }
        return ans;
    }
}
