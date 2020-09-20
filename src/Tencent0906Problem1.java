import java.util.*;

public class Tencent0906Problem1 {

    int n,m;
    int[] nums;
    int count = 0;
    boolean[] peopleFlag;
    boolean[] teamFlag;
    List<List<Integer>> teamList = new ArrayList<>();

    Deque<List<Integer>> listDeque = new LinkedList<>();

    public int getRes() {
        getTeamIncludeX(0);
        while (!listDeque.isEmpty()) {
            List<Integer> team = listDeque.poll();
            for (int i : team) {
                if (!peopleFlag[i]) {
                    count++;
                    getTeamIncludeX(i);
                    peopleFlag[i] = true;
                }
            }
        }
        return count;
    }

    public void getTeamIncludeX(int x) {
        for (int i = 0; i < teamList.size(); i++) {
            List<Integer> team = teamList.get(i);
            if (team.contains(x) && !teamFlag[i]) {
                listDeque.offer(team);
                teamFlag[i] = true;
            }
        }
    }

    public static void main(String[] args) {

        Tencent0906Problem1 solve = new Tencent0906Problem1();

        Scanner in = new Scanner(System.in);
        solve.n = in.nextInt();
        solve.m = in.nextInt();
        solve.nums = new int[solve.m];
        solve.peopleFlag = new boolean[solve.n];
        solve.teamFlag = new boolean[solve.m];

        for (int i = 0; i < solve.m; i++) {
            solve.nums[i] = in.nextInt();
            List<Integer> aTeam = new ArrayList<>();
            for (int j = 0; j < solve.nums[i]; j++) {
                aTeam.add(in.nextInt());
            }
            solve.teamList.add(aTeam);
        }

        System.out.println("**********");
        for (List<Integer> team : solve.teamList) {
            for (int i : team) {
                System.out.print(i+"   ");
            }
            System.out.println();
        }
        System.out.println("**********");

        System.out.println(solve.getRes());


        //50 5
        //2 1 2
        //5 10 11 12 13 14
        //2 0 1
        //2 49 2
        //4 6 7 8 2

    }
}
