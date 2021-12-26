import java.util.LinkedList;
import java.util.List;

class CombinationsBackTracking {
    /**Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order. */
    int n = 0;
    int k = 0;
    List<List<Integer>> output = new LinkedList<List<Integer>>();
      public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTrack(1,new LinkedList<Integer>());
        return output;
      }
    
    public void backTrack(int f, LinkedList<Integer> curr ){
        if(curr.size() == k)
            output.add(new LinkedList<Integer>(curr));
        
        for(int i=f ; i< n+1;i++){
            curr.add(i);
            backTrack(i+1, curr);
            curr.removeLast();
        }
    }
}