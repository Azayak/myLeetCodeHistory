public class LeetCode201 {

    public int rangeBitwiseAnd(int m, int n) {

        int mTemp = m,nTemp = n;
        int count = 0;
        while(mTemp!=nTemp){
            mTemp >>= 1;
            nTemp >>= 1;
            count++;
        }
        return mTemp << count;
    }
}
