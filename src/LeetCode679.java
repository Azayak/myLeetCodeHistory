public class LeetCode679 {

    public static double EPSILON = 0.000001;

    public boolean judgePoint24(int[] nums) {
        double[] nums_double = new double[4];
        for(int i=0;i<4;i++){
            nums_double[i] = nums[i];
        }
        return point24(nums_double,4);
    }

    public boolean point24(double[] nums,int t){
        if (t == 1){
            boolean flag = Math.abs(nums[0] - 24) < EPSILON;
            return flag;
        }
        else {
            boolean flag = false;
            for (int i = 0; i < t - 1; i++) {
                for (int j = i + 1; j < t; j++) {
                    double[] num2 = {nums[i], nums[j]};
                    double[] res = fourOperationsRes(num2);
                    double[] nums_next = new double[t-1];

                    for(int k = 0, l = 1; k < t; k++){
                        if(k != i && k != j){
                            nums_next[l] = nums[k];
                            l++;
                        }
                    }
                    for(int k = 0; k < 8; k++){
                        nums_next[0] = res[k];
                        flag = flag || point24(nums_next,t-1);
                    }
                }
            }
            return flag;
        }
    }

    public double[] fourOperationsRes(double[] num2){
        double[] res = new double[8];
        res[0] = num2[0] + num2[1];
        res[1] = num2[0] - num2[1];
        res[2] = num2[0] * num2[1];
        if(Math.abs(num2[1] - 0) < EPSILON)
            res[3] = 0;
        else
            res[3] = num2[0] / num2[1];

        res[4] = num2[1] + num2[0];
        res[5] = num2[1] - num2[0];
        res[6] = num2[1] * num2[0];
        if(Math.abs(num2[0] - 0) < EPSILON)
            res[7] = 0;
        else
            res[7] = num2[1] / num2[0];

        return res;
    }

    public static void main(String[] args) {
        LeetCode679 solve = new LeetCode679();
//        int[] nums = {4,1,8,7};
//        int[] nums = {6,6,6,6};
//        int[] nums = {6,6,2,3};
//        int[] nums = {8,4,7,1};
//        int[] nums = {1,2,1,2};
//        int[] nums = {8,7,4,1};
        int[] nums = {8,1,6,6};
//        int[] nums = {1,1,1,1};
//        int[] nums = {0,0,0,0};

        boolean res = solve.judgePoint24(nums);
        System.out.println(res);
    }
}
