import java.util.*;

public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//            }
//            else {
//                int count = map.get(num);
//                map.remove(num);
//                map.put(num, count + 1);
//            }
//        }
        List<Map.Entry<Integer, Integer>> numList = new ArrayList<>(map.entrySet());
        Collections.sort(numList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
            res[i] = numList.get(i).getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode347 solve = new LeetCode347();
        int[] nums = {1,1,1,2,2,3};
        int[] res = solve.topKFrequent(nums,2);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
