public class Offer21 {

    public int[] exchange(int[] nums) {
        //***********************************
        //遍历数组并对新数组赋值
        // int length = nums.length;
        // int[] res = new int[length];
        // int fornt = 0;
        // int rear = length-1;

        // for(int i=0;i<length;++i){
        //     if(nums[i]%2==0){
        //         res[rear] = nums[i];
        //         rear--;
        //     }
        //     else{
        //         res[fornt] = nums[i];
        //         fornt++;
        //     }
        // }
        // return res;
        //***********************************
        //交换前后数据
        int length = nums.length;
        int rear = length -1;
        int fornt = 0;
        int temp;
        while(fornt<rear){
            while((nums[fornt]%2 != 0)&&(fornt<length-1)) fornt++;
            while((nums[rear]%2 == 0)&&(rear>0)) rear--;
            if(fornt>=rear) break;
            temp = nums[fornt];
            nums[fornt] = nums[rear];
            nums[rear] = temp;
        }
        return nums;
    }
}
