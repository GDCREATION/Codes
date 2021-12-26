import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res  = new ArrayList<>();
            int k[] = new int[numRows];
            List<Integer> first= new ArrayList<>();
            first.add(1);
            k[0]=1;
            res.add(first);
            for(int i=1;i<numRows;i++){
                List<Integer> rest= new ArrayList<>();
                for(int j=i;j>0;j--){
                    k[j]=k[j]+k[j-1];
                    rest.add(k[j]);
                }
                rest.add(1);
                res.add(rest);
            }
            return res;
        }
    }
