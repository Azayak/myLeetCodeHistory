import java.util.Scanner;

public class Glodon1014_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String standard = in.nextLine();
        String mine = in.nextLine();
        in.close();
        int count = 0;
        for (int i = 0; i < standard.length(); i++) {
            if (mine.charAt(i) == standard.charAt(i)) {
                count += 20;
            }else {
                if (count > 0) {
                    count -= 10;
                }
            }
        }
        System.out.println(count);
    }
}
