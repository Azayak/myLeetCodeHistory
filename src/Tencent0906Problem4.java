import java.util.Scanner;

public class Tencent0906Problem4 {

    //歌曲最大播放时长问题


    //待完成
    public static int getRes(int num, int limitTime, int sum, int[] songsLength) {
        if (sum <= limitTime) return sum;
        else {

        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] songsLength = new int[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            songsLength[i] = in.nextInt();
            sum += songsLength[i];
        }
        int limitTime = in.nextInt();
        in.close();
        System.out.println(getRes(num, limitTime, sum, songsLength));

    }
}
