package graph;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	public int v;

	public static final int WHITE=0; // not visited
	public static final int GRAY=1; // visited and in process(in recursion call stack)
	public static final int BLACK=2; //visited and processed
	
	public static LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		adj =  new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void dfs(int v) {
		boolean[] visited = new boolean[this.v];

		dfsUtil(v, visited);
		
		// handling case for disconnected graphs, or if we have reached a node where no edges are present and we haven't
		//processed al nodes yet
		for(int i=0;i<this.v;i++) {
			if(!visited[i]) {
				dfsUtil(i, visited);
			}
		}
	}

	public void dfsUtil(int v, boolean[] visited) {
		// In dfs we first mark it as visited then use it, after that check for all its
		// unvisited neighbours and visit them
		// by calling dfs on them again, this way we can traverse whole graph

		visited[v] = true;

		System.out.print(v + " ");

		Iterator<Integer> it = adj[v].listIterator();

		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n]) {
				dfsUtil(n, visited);
			}
		}

	}
	
	public void bfs(int v) {
		boolean[] visited =  new boolean[this.v];
		
		bfsUtil(v, visited);
		
		// handling case for disconnected graphs, or if we have reached a node where no edges are present and we haven't
		//processed al nodes yet
		for(int i=0;i<visited.length;i++) {
			if(!visited[i]) {
				bfsUtil(i, visited);
			}
		}
	}

	/*
	 * In bfs we use queue to keep track of the adjacent nodes of current node and process them, main crux here is
	 * if we have not visited it add it to the queue and mark it as visited and do this until the queue is empty
	 * */
	private void bfsUtil(int v, boolean[] visited) {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
		
			Iterator<Integer> it = adj[current].listIterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					queue.add(n);
					visited[n]=true;
				}
			}
		}
		
	}
	
	/*
	 * Idea here is to use graph coloring method to identify the cycle,we start by filling all vertices to WHITE
	 *whenever we encounter an edge to a vertex which is already GRAY, then there is a cycle and we return true
	 *if not we process it
	 *when all its adjacent nodes are processed we mark it as BLACK
	 *O(V + E)
	 * can only be used on directed graphs
	 */
	
	public boolean isCyclic() {
		
		int[] colors =  new int[this.v];
		
		for(int i=0;i<colors.length;i++) {
			colors[i]=WHITE;
		}
		
		for(int i=0;i<this.v;i++) {
			
			if(colors[i]==WHITE) {
				if(isCyclicUtil(i, colors)) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean isCyclicUtil(int v, int[] colors) {
		
		colors[v] = GRAY;
		
		Iterator<Integer> it= adj[v].listIterator();
		
		while(it.hasNext()) {
			
			int n = it.next();
			
			if(colors[n]==GRAY) {
				return true;
			}
			
			if(colors[n] == WHITE && isCyclicUtil(n, colors)) {
				return true;
			}
			
		}
		
		colors[v] = BLACK;
		return false;
	}

	public static void main(String[] args) {

		Graph g = new Graph(7);

		g.addEdge(0, 1);
		g.addEdge(0, 0);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
		g.addEdge(3,6);
		
		
		System.out.println(g.isCyclic());
	}

}
