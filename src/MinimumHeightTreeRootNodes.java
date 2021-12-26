import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTreeRootNodes {
        class Nodes{
            int length;
            Set<Integer> attached;
            
            void setAttached(Integer n,Integer m){
                if(attached == null){
                    attached = new HashSet<>();
                }
                attached.add(n);
                length++;
                if(length == 1){
                    leafs.add(m);
                }
                else{
                    leafs.remove(m);
                }
            }
            
            Integer removeLeaf(Integer m){
                attached.remove(m);
                length--;
                return length;
            }
            
            Set<Integer> getAttached(){
                return attached;
            }
            
            int getLength(){
                return length;
            }
        }
        
        List<Integer> leafs = new ArrayList<>();
        
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            
            if(n<2){
                ArrayList<Integer> centroids = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    centroids.add(i);
                return centroids;
            }
            HashMap<Integer,Nodes> tree = new HashMap<>();
            for(int i=0;i<n-1;i++){
                int n1 = edges[i][0];
                int n2 = edges[i][1];
                setNodestoTree(tree,n1,n2);
                setNodestoTree(tree,n2,n1);
            }
            while(n>2){
                n-= leafs.size();
                List<Integer> newleafs = new ArrayList<>();
                
                for(Integer leaf : leafs){
                    Integer neighbour = tree.get(leaf).getAttached().iterator().next();
                    if(tree.get(neighbour).removeLeaf(leaf) == 1){
                        newleafs.add(neighbour);
                    }
                }
                leafs = newleafs;
            }
            
            return leafs;
            
        }
        
        void setNodestoTree(HashMap<Integer,Nodes> tree,Integer n,Integer m){
            Nodes nodes = new Nodes();
            if(tree.containsKey(n)){
                nodes = tree.get(n);
            }
            nodes.setAttached(m,n);
            tree.put(n,nodes);
        }
    }