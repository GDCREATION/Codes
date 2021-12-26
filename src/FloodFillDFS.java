public class FloodFillDFS {

    /**An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill. */
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if(image[sr][sc] == newColor)
                return image;
            coloured(image,sr,sc,image[sr][sc],newColor,image[0].length,image.length);
            return image;
        }
        
        public void coloured(int[][] image, int sr, int sc,int currColour, int newColor, int columnLength, int rowLength) {
            if(image[sr][sc]!=currColour)
                return;
            image[sr][sc]=newColor;
            if(sc>0){
                coloured(image,sr,sc-1,currColour,newColor,columnLength,rowLength);
            }
            if(sc<columnLength-1){
                coloured(image,sr,sc+1,currColour,newColor,columnLength,rowLength);
            }
            if(sr>0){
                coloured(image,sr-1,sc,currColour,newColor,columnLength,rowLength);
            }
            if(sr<rowLength-1){
                coloured(image,sr+1,sc,currColour,newColor,columnLength,rowLength);
            }
            
        }
    }