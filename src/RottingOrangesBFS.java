import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesBFS {

    /**You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1. */
    public int orangesRotting(int[][] mat) {
        int cl=mat[0].length;
        int rl=mat.length;
        Queue<Integer> queue = new LinkedList<>();
        int freshOranges = 0;
        int max = 0;
        
        for(int i =0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(mat[i][j]==2){
                    queue.add(i*cl+j);
                    mat[i][j]=0;
                }
                else if(mat[i][j]==1){
                mat[i][j]=-1;
                    freshOranges++;
                }
                    
                else{
                    mat[i][j]=-2;
                }
            }
        }

        while(!queue.isEmpty()){
            int r = queue.poll();
            int c = r%cl;
            r=r/cl;
            if(r < rl-1 && mat[r+1][c] ==-1){
                mat[r+1][c]=mat[r][c]+1;
                if(mat[r+1][c] > max)
                    max = mat[r+1][c];
                queue.add((r+1)*cl+c);
                freshOranges--;
            }
            if(r > 0 && mat[r-1][c] ==-1){
                mat[r-1][c]=mat[r][c]+1;
                if(mat[r-1][c] > max)
                    max = mat[r-1][c];
                queue.add((r-1)*cl+c);
                freshOranges--;
            }
            if(c < cl-1 && mat[r][c+1] ==-1){
                mat[r][c+1]=mat[r][c]+1;
                if(mat[r][c+1] > max)
                    max = mat[r][c+1];
                queue.add((r)*cl+c+1);
                freshOranges--;
            }
            if(c > 0 && mat[r][c-1] ==-1){
                mat[r][c-1]=mat[r][c]+1;
                if(mat[r][c-1] > max)
                    max = mat[r][c-1];
                queue.add((r)*cl+c-1);
                freshOranges--;
            }
        }
        
        if(freshOranges > 0)
            return -1;

        return max;
    }
    }
