import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFSIslandDepth {
    /**Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1. */
        public int[][] updateMatrix(int[][] mat) {
            int cl=mat[0].length;
            int rl=mat.length;
            Queue<Integer> queue = new LinkedList<>();
            for(int i =0;i<rl;i++){
                for(int j=0;j<cl;j++){
                    if(mat[i][j]==0)
                        queue.add(i*cl+j);
                    else
                        mat[i][j]=-1;
                }
            }
            
            while(!queue.isEmpty()){
                int r = queue.poll();
                int c = r%cl;
                r=r/cl;
                if(r < rl-1 && mat[r+1][c] ==-1){
                    mat[r+1][c]=mat[r][c]+1;
                    queue.add((r+1)*cl+c);
                }
                if(r > 0 && mat[r-1][c] ==-1){
                    mat[r-1][c]=mat[r][c]+1;
                    queue.add((r-1)*cl+c);
                }
                if(c < cl-1 && mat[r][c+1] ==-1){
                    mat[r][c+1]=mat[r][c]+1;
                    queue.add((r)*cl+c+1);
                }
                if(c > 0 && mat[r][c-1] ==-1){
                    mat[r][c-1]=mat[r][c]+1;
                    queue.add((r)*cl+c-1);
                }
            }
            
            return mat;
        }
    }
