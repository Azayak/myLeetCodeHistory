import java.util.*;

public class LeetCode332 {

//    public List<String> findItinerary(List<List<String>> tickets) {
//        List<String> resTrip = new ArrayList<>();
//        if(tickets.size() == 0) return resTrip;
//        HashMap<String, String> map = new HashMap<>();
//        for(List<String> ticket : tickets) {
//            map.put(ticket.get(0),ticket.get(1));
//        }
//
//
//        return resTrip;
//    }

        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        List<String> itinerary = new LinkedList<String>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String src = ticket.get(0), dst = ticket.get(1);
                if (!map.containsKey(src)) {
                    map.put(src, new PriorityQueue<String>());
                }
                map.get(src).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(itinerary);
            return itinerary;
        }

        public void dfs(String curr) {
            while (map.containsKey(curr) && map.get(curr).size() > 0) {
                String tmp = map.get(curr).poll();
                dfs(tmp);
            }
            itinerary.add(curr);
        }

}
