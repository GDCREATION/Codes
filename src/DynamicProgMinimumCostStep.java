public class DynamicProgMinimumCostStep {
        public int minCostClimbingStairs(int[] cost) {
            int l=cost.length;
            if(l==2)
                return Math.min(cost[0],cost[1]);
            for(int i=l-3;i>=0;i--){
                    cost[i]=cost[i]+Math.min(cost[i+1],cost[i+2]);
            }
            return Math.min(cost[0],cost[1]);
        }
    }
