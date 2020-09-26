public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            if (++count[num] == 2) {
                return num;
            }
        }
        return -1;
    }
}
