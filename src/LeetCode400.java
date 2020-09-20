/**
 * something wrong in this program
 */

public class LeetCode400 {

//    public int findNthDigit(int n) {
//        int temp = n;
//        int count = 1;
//        while(temp>0){
//            temp -= getNumLength(count);
//            count++;
//        }
//        temp += getNumLength(count-1);
//
//        return getRes(count-1,temp);
//    }
//
//    public int getNumLength(int n){
//        int length = 1;
//        while(n/10>0){
//            length++;
//            n /= 10;
//        }
//        return length;
//    }
//
//    public int getRes(int count,int x){
//        int length = getNumLength(count);
//        int pos = length-x;
//        int res;
//        for(int i=0;i<pos;i++){
//            count /= 10;
//        }
//        res = count%10;
//        return res;
//    }

    public int findNthDigit(int n) {
        long num=n;

        long size=1;
        long max=9;

        while(n>0){
            //判断不在当前位数内
            if(num-max*size>0){
                num=num-max*size;
                size++;
                max=max*10;
            }else{
                long count=num/size;
                long left=num%size;
                if(left==0){
                    return (int) (((long)Math.pow(10, size-1)+count-1)%10);
                }else{
                    return (int) (((long)Math.pow(10, size-1)+count)/((long)Math.pow(10, (size-left)))%10);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LeetCode400 solve = new LeetCode400();
        System.out.println(solve.findNthDigit(11));
//        System.out.println(solve.getNumLength(154645050));
//        System.out.println(solve.getRes(123456789,9));
    }
}
