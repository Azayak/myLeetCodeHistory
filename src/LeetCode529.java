import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode529 {

    int[] mx = {-1,-1,-1,0,0,1,1,1};
    int[] my = {-1,0,1,-1,1,-1,0,1};

    public char[][] updateBoard(char[][] board, int[] click) {
        if(isMine(board,click)){
            board[click[0]][click[1]] = 'X';
        }
        else if(getNearMineNum(board,click)!=0){
            board[click[0]][click[1]] = (char) (getNearMineNum(board,click) + '0');
        }
        else if(getNearMineNum(board,click)==0){
            List<List> resList = getNearBlankList(board,click);
            List<int[]> blankList = resList.get(0);
            List<int[]> nonBlankList = resList.get(1);
//            System.out.println("the list<list> has been return");
            for(int i=0;i<blankList.size();i++){
                int[] blankPos = blankList.get(i);
                board[blankPos[0]][blankPos[1]] = 'B';
            }
            for(int i=0;i<nonBlankList.size();i++){
                int[] nonBlankPos = nonBlankList.get(i);
                board[nonBlankPos[0]][nonBlankPos[1]] = (char) (nonBlankPos[2] + '0');
            }
        }
        return board;
    }

    public boolean isMine(char[][] board,int[] click){
        return board[click[0]][click[1]] == 'M';
    }

    public int getNearMineNum(char[][] board,int[] click){
        int mineNum = 0;

        for(int i=0;i<8;i++){
            if(click[0]+mx[i]>=0&&click[0]+mx[i]<board.length&&click[1]+my[i]>=0&&click[1]+my[i]<board[0].length){
                if(board[click[0]+mx[i]][click[1]+my[i]]=='M'){
                    mineNum++;
                }
            }
        }
        return mineNum;
    }

    public List<List> getNearBlankList(char[][] board, int[] click){
//        System.out.println("getNearBlankList entry");
        Queue<int[]> blankQueue = new ArrayDeque<>();
        List<int[]> blankList = new ArrayList<>();
        List<int[]> nonBlankList = new ArrayList<>();

        List<List> resList = new ArrayList<>();

        int[][] flag = new int[board.length][board[0].length];
        for(int i=0;i<flag.length;i++){
            for(int j=0;j<flag[0].length;j++){
                flag[i][j] = 0;
            }
        }

        blankQueue.add(click);

        while(!blankQueue.isEmpty()){
            int[] pos = blankQueue.poll();
//            System.out.println("[ "+pos[0]+","+pos[1]+" ]");

            blankList.add(pos);

            for(int i=0;i<8;i++){
                if(pos[0]+mx[i]>=0&&pos[0]+mx[i]<board.length&&pos[1]+my[i]>=0&&pos[1]+my[i]<board[0].length){
                    int[] nearPos = {pos[0]+mx[i],pos[1]+my[i]};
                    int nearMineNum = getNearMineNum(board,nearPos);
                    if(nearMineNum==0&&flag[nearPos[0]][nearPos[1]]==0){
                        flag[nearPos[0]][nearPos[1]] = 1;
                        blankQueue.add(nearPos);
                    }
                    else if(nearMineNum!=0&&flag[nearPos[0]][nearPos[1]]==0){
                        int[] posAndNum = {nearPos[0],nearPos[1],nearMineNum};
                        flag[nearPos[0]][nearPos[1]] = 1;
                        nonBlankList.add(posAndNum);
                    }
                }
            }
        }
        resList.add(blankList);
        resList.add(nonBlankList);
        return resList;
    }

    public void printChar(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        LeetCode529 solve = new LeetCode529();
        char[][] board =    {{'E', 'E', 'E', 'E', 'E'},
                            {'E', 'E', 'M', 'E', 'E'},
                            {'E', 'E', 'E', 'E', 'E'},
                            {'E', 'E', 'M', 'E', 'E'},
                            {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3,0};
//        int[] click = {1,2};
//        int[] click = {0,1};
        solve.printChar(board);
        board = solve.updateBoard(board,click);
        System.out.println("*****************************");
        solve.printChar(board);
    }

}
