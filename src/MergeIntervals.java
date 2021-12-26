import java.util.*;

public class MergeIntervals {
    /**Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]. */
        public int[][] merge(int[][] intervals) {
            
            int len =intervals.length;
            if(len == 1)
                return intervals;
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<int[]> res = new ArrayList<>();
            int min=intervals[0][0]; int max= intervals[0][1];
            for(int i=1;i<len;i++){
                
                if(intervals[i][0]<= max){
                    max = Math.max(intervals[i][1],max);
                }else{
                    res.add(new int[]{min,max});
                    min = intervals[i][0];
                    max = intervals[i][1];
                }
                if(i== len-1){
                    res.add(new int[]{min,max});
                }
                
            }
            int res1[][]=new int[res.size()][2];
            for (int i = 0; i < res.size(); i++)
                res1[i] = res.get(i);
            return res1;
            
        }
    }
