import java.util.*;

public class YueWen1021_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        long[] id = new long[n];
        int[] category = new int[n];
        int[] words = new int[n];
        String[] updatetime = new String[n];
        List<List<Object>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Object> one = new ArrayList<>();
            String input = in.nextLine();
            String[] reg = input.split(",");
            id[i] = Long.parseLong(reg[0]);
            category[i] = Integer.parseInt(reg[1]);
            words[i] = Integer.parseInt(reg[2]);
            updatetime[i] = reg[3];
            one.add(id[i]);
            one.add(category[i]);
            one.add(words[i]);
            one.add(updatetime[i]);
            list.add(one);
        }
        Collections.sort(list, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                long id1 = (long) o1.get(0);
                int category1 = (int) o1.get(1);
                int words1 = (int) o1.get(2);
                String updatetime1 = (String) o1.get(3);

                long id2 = (long) o2.get(0);
                int category2 = (int) o2.get(1);
                int words2 = (int) o2.get(2);
                String updatetime2 = (String) o2.get(3);

                if (category1 > category2) {
                    return 1;
                } else if (category1 < category2) {
                    return -1;
                } else {
                    if (updatetime1.compareTo(updatetime2) > 0) {
                        return 1;
                    } else if (updatetime1.compareTo(updatetime2) < 0) {
                        return -1;
                    } else {
                        if (words1 > words2) {
                            return 1;
                        } else if (words1 < words2) {
                            return -1;
                        } else {
                            if (id1 > id2) {
                                return 1;
                            } else if (id1 < id2) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        });
        for (List<Object> oneBook : list) {
            long theId = (long) oneBook.get(0);
            System.out.println(theId);
        }
    }
}
