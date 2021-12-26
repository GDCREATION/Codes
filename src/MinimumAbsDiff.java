import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr */
public class MinimumAbsDiff {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
    
            int minPairDiff = Integer.MAX_VALUE;
            List<List<Integer>> answer = new ArrayList<>();
            for (int i = 0; i < arr.length - 1; ++i) {
                int currPairDiff = arr[i + 1] - arr[i];
                if (currPairDiff == minPairDiff) {
                    answer.add(Arrays.asList(arr[i], arr[i + 1]));
                } else if (currPairDiff < minPairDiff) {
                    answer.clear();
                    answer.add(Arrays.asList(arr[i], arr[i + 1]));
                    minPairDiff = currPairDiff;
                }
            }
    
            return answer;   
        }
    }