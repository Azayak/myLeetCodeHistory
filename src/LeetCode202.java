public class LeetCode202 {

    public boolean isHappy(int n) {
        int slow = n, fast = getSqrNum(n);
        while (fast != 1 && slow != fast) {
            slow = getSqrNum(slow);
            fast = getSqrNum(getSqrNum(fast));
        }
        return fast == 1;
    }

    public int getSqrNum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
