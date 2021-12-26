
import java.util.*;
class DFS {
	
	 static private boolean visited[];
	 
	 static private List<Edge> graph[];
	 
	 public DFS(int size)
    {
        visited = new boolean[size];
        graph = new ArrayList[size];
    }
	
	 static class Edge {
        int u;
        int v;
        int w;
        Edge(int u, int v, int w)
        {
            this.u = u;
            this.v = v;
            this.w = w;
        }
	 }
	
	 private void helperInitialize(int size)
	 {
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<Edge>();
        }
	 }
	
	
	 public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        
        int k= s.nextInt();  
        DFS obj = new DFS(k);
        
        obj.helperInitialize(k);
        
        for(int i = 0 ;i< k; i++){
            	int a = s.nextInt();
            	int b = s.nextInt();
            	int c = s.nextInt();
            	Edge e = new Edge(a,b,c);
            	graph[a].add(e);
            
        }

        int start = s.nextInt();
        int end = s.nextInt();
        int U_V[] = { start, end };
        
        dfs(U_V[0], 9999);
        
        if (visited[U_V[1]]) {
            System.out.print(1);
        }
        else {
            System.out.print(0);
        }
	 }

	 static private void dfs(int S, int W)
    {
 
        // Marking the vertex visited
        visited[S] = true;
 
        // Traversing adjacent vertex
        for (Edge uv : graph[S]) {
            int ver = uv.v;
            int w = uv.w;
            if (!visited[ver] && w < W)
                dfs(ver, W);
        }
    }

}
