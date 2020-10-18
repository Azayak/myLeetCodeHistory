public class LeetCode977 {

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int flag = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                flag = i;
                break;
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        int left = flag - 1, right = flag;
        int index = 0;
        while (left >= 0 || right < A.length) {
            if (left < 0) {
                while (index < A.length) {
                    res[index++] = A[right++];
                }
            } else if (right >= A.length) {
                while (index < A.length) {
                    res[index++] = A[left--];
                }
            } else if (A[left] <= A[right]) {
                res[index++] = A[left--];
            } else {
                res[index++] = A[right++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode977 solve = new LeetCode977();
        int[] A = {-7,-3,2,3,11};
        int[] res = solve.sortedSquares(A);
        for (int num : res) {
            System.out.print(num + "   ");
        }
    }
}
