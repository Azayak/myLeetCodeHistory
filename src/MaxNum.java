public class MaxNum {

    public int getMaxRes(int[] nums, int target) {
        int res = 0;
        int length = nums.length;

        int[] sum = new int[length];
        int tempSum = 0;
        for (int i = 0; i < length; i++) {
            tempSum += i;
            sum[i] = tempSum;
        }


        int[][] sums = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                sums[i][j] = sum[j] - sum[i];
                if (sums[i][j] == target) {
                    res = Math.max(res,j - i);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        MaxNum solve = new MaxNum();
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        int target = 9;
        System.out.println(solve.getMaxRes(nums,target));
    }


}
