import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        for (int i1 = 1; i1 <= 3; i1++) {
            for (int i2 = 1; i2 <= 3; i2++) {
                for (int i3 = 1; i3 <= 3; i3++) {


                    for (int i4 = 1; i4 <= 3; i4++) {
                        if (i1 + i2 + i3 + i4 == length) {
                            int[] ip = new int[4];
                            ip[0] = Integer.parseInt(s.substring(0, i1));
                            ip[1] = Integer.parseInt(s.substring(i1, i1 + i2));
                            ip[2] = Integer.parseInt(s.substring(i1 + i2, i1 + i2 + i3));
                            ip[3] = Integer.parseInt(s.substring(i1 + i2 + i3, length));
                            if (ip[0] >= 0 && ip[0] <= 255 && ip[1] >= 0 && ip[1] <= 255 && ip[2] >= 0 && ip[2] <= 255 && ip[3] >= 0 && ip[3] <= 255) {
                                String oneIP = String.valueOf(ip[0]) + '.' + ip[1] + '.' + ip[2] + '.' + ip[3];
                                if (oneIP.length() == s.length() + 3) {
                                    res.add(oneIP);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode93 solve = new LeetCode93();
        String s = "1230456";
        List<String> res = solve.restoreIpAddresses(s);
        for (String ip : res) {
            System.out.println(ip);
        }
    }

}
