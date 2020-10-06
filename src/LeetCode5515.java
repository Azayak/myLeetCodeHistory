public class LeetCode5515 {
    class ParkingSystem {
        int[] sum;
        public ParkingSystem(int big, int medium, int small) {
            this.sum = new int[]{big,medium,small};
        }
        public boolean addCar(int carType) {
            return sum[carType - 1]-- > 0;
        }
    }
}
