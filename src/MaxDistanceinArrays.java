import java.util.List;

/**You are given m arrays, where each array is sorted in ascending order.

You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|.

Return the maximum distance. */

public class MaxDistanceinArrays {
        public int maxDistance(List<List<Integer>> arrays) {
            int l1=Integer.MIN_VALUE,i1=0;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,j1=0;
            int r2=Integer.MAX_VALUE;
            
            for(int i=0;i<arrays.size();i++){
                List<Integer> list = arrays.get(i);
                int sm = list.get(0);
                int lg = list.get(list.size()-1);
                if(sm <= r1){
                    r2=r1;
                    r1=sm;
                    j1=i;
                }
                else if(r1<sm && r2>sm)
                    r2 = sm;
                
                if(lg >= l1){
                    l2=l1;
                    l1=lg;
                    i1=i;
                }
                else if(l1>lg && l2<lg)
                    l2 = lg;
            }
            
            if(j1 == i1){
                if(Math.abs(l1-r2)>Math.abs(l2-r1))
                    return Math.abs(l1-r2);
                else
                    return Math.abs(l2-r1);
            }
            
            return Math.abs(l1-r1);
            
        }
    }
