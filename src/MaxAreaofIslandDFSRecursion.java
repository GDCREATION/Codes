public class MaxAreaofIslandDFSRecursion {
        public int maxAreaOfIsland(int[][] grid) {
            int maxIsland = 0;
            int columnLength = grid[0].length;
            int rowLength = grid.length;
            for(int i=0; i<rowLength; i++){
                for(int j=0; j<columnLength;j++){
                    if(grid[i][j]==1){
                        int currIslandArea = islandArea(grid,i,j,columnLength,rowLength);
                         if(currIslandArea > maxIsland)
                             maxIsland = currIslandArea;
                    }
                }
            }
            return maxIsland;
        }
        
        public int islandArea(int[][] image, int sr, int sc, int columnLength, int rowLength) {
                int len =0;
                if(image[sr][sc]!=1)
                    return 0;
                image[sr][sc]=999;
                if(sc>0){
                    len+=islandArea(image,sr,sc-1,columnLength,rowLength);
                }
                if(sc<columnLength-1){
                    len+=islandArea(image,sr,sc+1,columnLength,rowLength);
                }
                if(sr>0){
                    len+=islandArea(image,sr-1,sc,columnLength,rowLength);
                }
                if(sr<rowLength-1){
                    len+=islandArea(image,sr+1,sc,columnLength,rowLength);
                }
                return len+1;
            }
    }
