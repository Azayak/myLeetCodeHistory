public class Offer63 {
    public int maxProfit(int[] prices) {
        //暴力求解
        // int length = prices.length;
        // int res = 0;
        // for(int i=0;i<length;++i){
        //     for(int j=i;j<length;++j){
        //         if((prices[j]-prices[i])>res) res = prices[j]-prices[i];
        //     }
        // }
        // return res;

        //贪心
        int length = prices.length;
        int res = 0;
        int temp = 0;
        if(length==0||length==1) return 0;
        int[] change = new int[length-1];
        for(int i=0;i<length-1;++i)
            change[i] = prices[i+1] - prices[i];
        int j = 0;
        while(j<length-1){
            if(temp>=0) temp += change[j];
            if(temp<0) temp = 0;
            if(temp>res) res = temp;
            ++j;
        }
        return res;
    }
}
