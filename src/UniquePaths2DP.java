public class UniquePaths2DP {
        public int uniquePathsWithObstacles(int[][] a) {
            int l1 = a.length;
            int l2 = a[0].length;
            for(int i = 0;i<l1;i++){
                for(int j=0;j<l2;j++){
                    if(a[i][j]==1)
                        a[i][j]=-1;
                    else if((i==0 && j>0 && a[i][j-1]==-1) || (j==0 && i>0 && a[i-1][j]==-1))
                        a[i][j]=-1;
                    else if(i==0 || j==0)
                        a[i][j]=1;
                    else{
                        int r=a[i][j-1],k=a[i-1][j];
                        if(r == -1)
                            r = 0;
                        if(k == -1)
                            k = 0;
                        a[i][j]=r+k;
                    }
                }
            }
            return a[l1-1][l2-1] == -1 ? 0 : a[l1-1][l2-1];
        }
    }
