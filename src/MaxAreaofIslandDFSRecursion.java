public class MaxAreaofIslandDFSRecursion {

    /**You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0. */

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
