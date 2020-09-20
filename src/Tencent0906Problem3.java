import java.util.*;

public class Tencent0906Problem3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        String[] S = new String[N];
        in.nextLine();
        for (int i = 0; i < N; i++) {
            S[i] = in.nextLine();
        }
        in.close();
        Map<String,Integer> map = new HashMap<>();
        for (String s : S) {
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.remove(s);
                map.put(s, count + 1);
            }
            else {
                map.put(s, 1);
            }
        }
        Map<Integer, String> map1 = new HashMap<>();

        Collection<Integer> collection = map.values();

        List<Map.Entry<String,Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) return o2.getValue() - o1.getValue();
                else return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i <= K - 1; i++) {
            System.out.println(mapList.get(i).getKey()+" "+mapList.get(i).getValue());
        }

        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) return o1.getValue() - o2.getValue();
                else return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i <= K - 1; i++) {
            System.out.println(mapList.get(i).getKey()+" "+mapList.get(i).getValue());
        }


    }
}
