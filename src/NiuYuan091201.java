import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class NiuYuan091201 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Deque<Integer> porks = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            porks.offer(in.nextInt());
        }
        in.close();
        for (int i = 0; i < M; i++) {
            Deque<Integer> porks1 = new LinkedList<>();
            Deque<Integer> porks2 = new LinkedList<>();
            for (int turns = 0; turns < N; turns++) {
                if (turns < N / 2) {
                    porks1.offer(porks.poll());
                }
                else {
                    porks2.offer(porks.poll());
                }
            }
            while (!porks1.isEmpty() || !porks2.isEmpty()) {
                if (!porks2.isEmpty()) {
                    porks.offer(porks2.poll());
                }
                if (!porks1.isEmpty()) {
                    porks.offer(porks1.poll());
                }
            }
        }
        for (int i : porks) {
            System.out.print(i+"   ");
        }
        System.out.println();
    }
}
