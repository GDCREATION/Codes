import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;


public class DijkstraUsingMap {
	
	static class Node{
		int vertex;
		int weight;
		
		Node(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
		
		public int getVertex() {
			return vertex;
		}
		public void setVertex(int vertex) {
			this.vertex = vertex;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,ArrayList<Node>> graph = new HashMap<Integer, ArrayList<Node>>();
		Map<Integer, Integer> lengthNodes = new HashMap<Integer, Integer>();
		Scanner sc = new Scanner(System.in);
		try {
			int num = sc.nextInt();
			for(int i =0 ;i<num ;i++) {
				int src = sc.nextInt();
				int dest = sc.nextInt();
				int weight = sc.nextInt();
				ArrayList<Node> addedNodes;
				if(graph.containsKey(src)) {
					addedNodes = graph.get(src);
				}else {
					addedNodes = new ArrayList<Node>();
				}
				Node node = new Node(dest,weight);
				addedNodes.add(node);
				graph.put(src, addedNodes);
				lengthNodes.put(src, Integer.MAX_VALUE);
			}
			
			int startingPoint = sc.nextInt();
			Map<Integer,Integer> destNodes = dijkstra(startingPoint,graph,lengthNodes);
			for(Integer key : destNodes.keySet()) {
				System.out.println(key+"    "+destNodes.get(key));
			}
		}
		finally {
			sc.close();
		}
	}

	private static Map<Integer, Integer> dijkstra(int startingPoint, Map<Integer, ArrayList<DijkstraUsingMap.Node>> graph, Map<Integer, Integer> lengthNodes) {
		
		lengthNodes.put(startingPoint, 0);
		PriorityQueue<Node>  pq = new PriorityQueue<DijkstraUsingMap.Node>((v1,v2)->v1.getWeight()-v2.getWeight());
		
		pq.add(new Node(startingPoint,0));
		
		while(pq.size() != 0) {
			Node lastNode = pq.poll();
			for(Node node : graph.get(lastNode.getVertex())) {
					if(lengthNodes.get(lastNode.getVertex())+node.getWeight() < lengthNodes.get(node.getVertex())) {
						lengthNodes.put(node.getVertex(), lengthNodes.get(lastNode.getVertex())+node.getWeight());
		                pq.add(new Node(node.getVertex(),lengthNodes.get(node.getVertex())));
					}
				}
			}
		return lengthNodes;
	}

}
