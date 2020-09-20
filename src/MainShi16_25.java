import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MainShi16_25 {

//    class LRUCache {
//        Map<Integer, Integer> map = new HashMap<>();
//        int capacity;
//        int containNum;
//
//        public LRUCache(int capacity) {
//            this.capacity = capacity;
//            this.containNum = 0;
//        }
//
//        public int get(int key) {
//            if (map.containsKey(key)) {
//                map.put(key, map.get(key) + 1);
//                return key;
//            }
//            else {
//                return -1;
//            }
//        }
//
//        public void put(int key, int value) {
//            if (map.containsKey(key)) {
//                map.put(key, map.get(key) + value);
//            }
//            else if (containNum < capacity) {
//                map.put(key, value);
//                containNum++;
//            }
//            else {
//                int lastKey = 0, lastValue = Integer.MAX_VALUE;
//                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                    if (entry.getValue() < lastValue) {
//                        lastKey = entry.getKey();
//                    }
//                }
//                map.remove(lastKey);
//                map.put(key, value);
//            }
//        }
//    }


    class LRUCache {

        private final int capacity;
        private HashMap<Integer,Integer> map;
        private LinkedList<Integer> list;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.list = new LinkedList<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.remove((Integer) key);
                list.addLast(key);
                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                list.remove((Integer) key);
                list.addLast(key);
                map.put(key, value);
            }
            else if (list.size() == capacity) {
                map.remove(list.removeFirst());
                map.put(key, value);
                list.addLast(key);
            }
            else{
                map.put(key,value);
                list.addLast(key);
            }
        }
    }
}
