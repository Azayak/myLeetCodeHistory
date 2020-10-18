import java.util.*;

public class XieCheng1013_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        List<Integer> valueA = new ArrayList<>();
        List<Integer> valueB = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("#")) break;
            String[] values = s.split(" ");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            if (a <= 0 || b <= 0 || a > 1000 || b > 1000) {
                System.out.println("error");
                System.exit(-1);
            }
            valueA.add(a);
            valueB.add(b);
        }
        if ((valueA.size() % 2) != 0) {
            System.out.println("error");
            System.exit(-1);
        }
        int[][] cha = new int[valueA.size()][2];
        for (int i = 0; i < valueA.size(); i++) {
            cha[i][0] = valueA.get(i) - valueB.get(i);
            cha[i][1] = i;
        }
        Arrays.sort(cha, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < cha.length; i++) {
            if (2 * i < cha.length) {
                sum += valueB.get(cha[i][1]);
            }
            else {
                sum += valueA.get(cha[i][1]);
            }
        }
        System.out.println(sum);
    }
}