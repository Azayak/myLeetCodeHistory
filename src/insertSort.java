public class insertSort {


    public static void sort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void bobSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }


    public static void insertSort(int[] ins){
        for (int i = 1; i < ins.length; i++){
            int temp = ins[i];
            int j;
            for (j = i; j > 0 && ins[j - 1] > temp; j--) {
                ins[j] = ins[j - 1];
            }
            ins[j] = temp;
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = i; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            nums[minIndex] = nums[i];
            nums[i] = min;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {2,3,5,1,23,6,78,34};
//        sort(nums);
//        bobSort(nums);
        selectSort(nums);
        for(int num : nums){
            System.out.print(num + "   ");
        }
        System.out.println();
    }
}
