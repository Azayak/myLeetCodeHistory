import java.util.*;

public class YueWen1021_04 {
    /**
     * 计算int对应二进制中1的个数
     * @param n int整型 数字
     * @return int整型
     */
    public int countBit (int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
