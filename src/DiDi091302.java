import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DiDi091302 {

    public static double E = 10e-6;
    public int res = 0;
    Set<Set<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        DiDi091302 solve = new DiDi091302();
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        in.close();
        solve.getRes(3, 6, 0, 0, new HashSet<>());
        System.out.println(solve.res);


    }

    public void getRes(int n, int m, int num, double sum, Set<Integer> set1) {
        if (num <= n - 1) {

            for (int i = 1; i <= m; i++) {
                sum += 1 / (double) i;
                set1.add(i);
                if (1 - sum > E) {
                    getRes(n, m, num + 1, sum, set1);
                }
                sum -= 1 / (double) i;
                set1.remove(i);
            }
        }
        else {
            System.out.print(num+"   |");
//        else if(Math.abs(sum - 1) < E){
//            double last = 1 - sum;
//            int temp = (int) (last + 0.5);
//            if (Math.abs(temp - last) < E) {
//                set1.add(temp);
                if (!set.contains(set1)) {
                    Set<Integer> set2 = new HashSet<>(set1);
                    for (Integer a : set2) {
                        System.out.print(a + "   ");
                    }
                    System.out.println();
                    set.add(set2);
                    res++;
                }
//            }
        }

    }


}
