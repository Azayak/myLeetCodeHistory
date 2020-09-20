import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCode1178 {

    int simplify(String s) {
        int res=0;
        for (char c : s.toCharArray()) {
            res |= (1 << (c - 'a'));
        }
        return res;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> list = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : words) {
            int sim = simplify(s);
            map.put(sim,map.getOrDefault(sim,0) + 1);
        }
        for (String s : puzzles) {
            int sim = simplify(s);
            int sum=0;
            for (int i = sim; i > 0; i = (i - 1) & sim) {
                if(((1<<(s.charAt(0)-'a'))&i)!=0){
                    sum += map.getOrDefault(i, 0);
                }

            }
            list.add(sum);
        }
        return list;
    }
}
