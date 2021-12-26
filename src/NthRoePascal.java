import java.util.ArrayList;
import java.util.List;

public class NthRoePascal {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 0)
            return res;
        
        for(int i=1;i<rowIndex+1;i++){
            res.add(i,0);
            for(int j=i;j>0;j--){
                res.set(j,res.get(j)+res.get(j-1));
            }
        }
        return res;
    }
}
