public class BestSightDP {
    /**You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots. */
        public int maxScoreSightseeingPair(int[] values) {
            int max = values[1]+values[0]-1;
            int s = values[0]-1 > values[1]?values[0]-1:values[1];
            for(int i=2;i<values.length;i++){
               s--;
               int v = values[i];
               max = Math.max(max, s + v);
               s = Math.max(s, v);
            }
            return max;
        }
    }
