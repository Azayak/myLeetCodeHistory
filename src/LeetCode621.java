import java.util.Arrays;

public class LeetCode621 {

//    public int leastInterval(char[] tasks, int n) {
//        char[] taskArray = new char[26];
//        for (char task : tasks) {
//            taskArray[task - 'A']++;
//        }
//
//    }

//    public int leastInterval(char[] tasks, int n) {
//        int[] taskArray = new int[26];
//        for (char c: tasks) {
//            taskArray[c - 'A']++;
//        }
//        Arrays.sort(taskArray);
//        int time = 0;
//        while (taskArray[25] > 0) {
//            int i = 0;
//            while (i <= n) {
//                if (taskArray[25] == 0) break;
//                if (i < 26 && taskArray[25 - i] > 0) {
//                    taskArray[25 - i]--;
//                }
//                time++;
//                i++;
//            }
//            Arrays.sort(taskArray);
//        }
//        return time;
//    }

    public int leastInterval(char[] tasks, int n) {
        int[] taskArray = new int[26];
        for (char c: tasks)
            taskArray[c - 'A']++;
        Arrays.sort(taskArray);
        int max_val = taskArray[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && taskArray[i] > 0; i--) {
            idle_slots -= Math.min(taskArray[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
