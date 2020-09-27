public class LeetCode1287 {

    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) return arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (count > arr.length / 4) return arr[i];
            }
            else {
                count = 1;
            }
        }
        return -1;
    }
}
