public class LeetCode134 {

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int length = gas.length;
//        int gasSum = 0;
//        int costSum = 0;
//        int[] temp = new int[length];
//        for (int i = 0; i < length; i++) {
//            gasSum += gas[i];
//            costSum += cost[i];
//            temp[i] = gas[i] - cost[i];
//        }
//        if (gasSum < costSum) {
//            return -1;
//        }
//        for (int i = 0; i < length; i++) {
//            if (temp[i] < 0) {
//                continue;
//            }
//            boolean flag = true;
//            int resGas = 0;
//            for (int j = 0; j < length; j++) {
//                resGas += temp[(i + j) % length];
//                if (resGas < 0) {
//                    flag = false;
//                    i = (i + j) % length;
//                }
//            }
//            if (flag) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int gasSum = 0;
        int costSum = 0;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            temp[i] = gas[i] - cost[i];
        }
        if (gasSum < costSum) {
            return -1;
        }
        int resGas = 0;
        int res = 0;
        for (int i = 0; i < length; ++i) {
            resGas += temp[i];
            if (resGas < 0) {
                res = i + 1;
                resGas = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode134 solve = new LeetCode134();
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(solve.canCompleteCircuit(gas,cost));
    }
}
