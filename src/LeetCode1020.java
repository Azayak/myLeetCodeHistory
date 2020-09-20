import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1020 {

    int[] mx = {-1,0,0,1};
    int[] my = {0,-1,1,0};

    public int numEnclaves(int[][] A) {
        return BFS(A);
    }

    public int DFS(int[][] A){
        int res = findLandNum(A);
        int[][] flag = new int[A.length][A[0].length];
        Deque<int[]> posQueue = new LinkedList<>();
        for(int i=0;i<A.length;i++){
            int[] pos1 = {i,0};
            int[] pos2 = {i,A[0].length-1};
            if(A[pos1[0]][pos1[1]]==1&&flag[pos1[0]][pos1[1]]==0) {
                flag[pos1[0]][pos1[1]] = 1;
                posQueue.push(pos1);
            }
            if(A[pos2[0]][pos2[1]]==1&&flag[pos2[0]][pos2[1]]==0) {
                flag[pos2[0]][pos2[1]] = 1;
                posQueue.push(pos2);
            }
        }
        for(int i=0;i<A[0].length;i++){
            int[] pos1 = {0,i};
            int[] pos2 = {A.length-1,i};
            if(A[pos1[0]][pos1[1]]==1&&flag[pos1[0]][pos1[1]]==0) {
                flag[pos1[0]][pos1[1]] = 1;
                posQueue.push(pos1);
            }
            if(A[pos2[0]][pos2[1]]==1&&flag[pos2[0]][pos2[1]]==0) {
                flag[pos2[0]][pos2[1]] = 1;
                posQueue.push(pos2);
            }
        }

        while(!posQueue.isEmpty()){
            int[] thisPos = posQueue.pop();
            res--;
            for(int i=0;i<4;i++){
                int[] nearPos = {thisPos[0]+mx[i],thisPos[1]+my[i]};
                if(nearPos[0]>=0&&nearPos[0]<A.length&&nearPos[1]>=0&&nearPos[1]<A[0].length&&
                        A[nearPos[0]][nearPos[1]]==1&&flag[nearPos[0]][nearPos[1]]==0){
                    posQueue.push(nearPos);
                    flag[nearPos[0]][nearPos[1]] = 1;
                }
            }
        }

        return res;
    }

    public int BFS(int[][] A){
        int res = findLandNum(A);
        int[][] flag = new int[A.length][A[0].length];
        Deque<int[]> posQueue = new LinkedList<>();
        for(int i=0;i<A.length;i++){
            int[] pos1 = {i,0};
            int[] pos2 = {i,A[0].length-1};
            if(A[pos1[0]][pos1[1]]==1&&flag[pos1[0]][pos1[1]]==0) {
                flag[pos1[0]][pos1[1]] = 1;
                posQueue.offer(pos1);
            }
            if(A[pos2[0]][pos2[1]]==1&&flag[pos2[0]][pos2[1]]==0) {
                flag[pos2[0]][pos2[1]] = 1;
                posQueue.offer(pos2);
            }
        }
        for(int i=0;i<A[0].length;i++){
            int[] pos1 = {0,i};
            int[] pos2 = {A.length-1,i};
            if(A[pos1[0]][pos1[1]]==1&&flag[pos1[0]][pos1[1]]==0) {
                flag[pos1[0]][pos1[1]] = 1;
                posQueue.offer(pos1);
            }
            if(A[pos2[0]][pos2[1]]==1&&flag[pos2[0]][pos2[1]]==0) {
                flag[pos2[0]][pos2[1]] = 1;
                posQueue.offer(pos2);
            }
        }

        while(!posQueue.isEmpty()){
            int[] thisPos = posQueue.poll();
            res--;
            for(int i=0;i<4;i++){
                int[] nearPos = {thisPos[0]+mx[i],thisPos[1]+my[i]};
                if(nearPos[0]>=0&&nearPos[0]<A.length&&nearPos[1]>=0&&nearPos[1]<A[0].length&&
                        A[nearPos[0]][nearPos[1]]==1&&flag[nearPos[0]][nearPos[1]]==0){
                    posQueue.offer(nearPos);
                    flag[nearPos[0]][nearPos[1]] = 1;
                }
            }
        }

        return res;
    }


    public int findLandNum(int[][] A){
        int res = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1)
                    res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode1020 solve = new LeetCode1020();
        int[][] A = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(A.length+"   "+A[0].length);
        System.out.println(solve.numEnclaves(A));
    }

}
