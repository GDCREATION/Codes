import java.util.List;

public class TriangleDynamic {
        public int minimumTotal(List<List<Integer>> triangle) {
            /**Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. 
More formally, if you are on index i on the current row,
 you may move to either index i or index i + 1 on the next row. */
            for(int i=triangle.size()-2;i>=0;i--){
                for(int j=0;j<triangle.get(i).size();j++){
                    triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
                }
            }
            return triangle.get(0).get(0);
        }
    }
