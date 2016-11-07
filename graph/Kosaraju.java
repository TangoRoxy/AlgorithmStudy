package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Kosaraju {
	Vertex[] graph;
	LinkedList<Integer> order;
	List<List<Integer>> scc;
	private boolean[] visited;
	private Stack<Integer> stack;
	private Stack<Integer> orderStack = new Stack<Integer>();
	
	public Kosaraju(Vertex[] g){
		graph = g;
		order = new LinkedList<Integer>();
		scc = new ArrayList<List<Integer>>();
		stack = new Stack<Integer>();
		visited = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++){
			visited[i] = false;
		}
	
	}
	
	public void doMagic(){
		
		for(int i = 0; i < graph.length; i++){
			//visit(i);
			stack.push(i);
			while (!stack.isEmpty()){
				int cur = stack.pop();
				if (visited[cur]) {
					continue;
				}
				orderStack.push(cur);
				visited[cur] = true;
				Vertex v = graph[cur];
				for (Integer vertex: v.outNeighbors){
					stack.push(vertex);
				}
			}
			while(!orderStack.isEmpty()){
				order.addFirst(orderStack.pop());
			}
		}
		
		
		
//		for(Integer i: order)
		for(Integer i: order){
			if (visited[i]){
				List<Integer> component = new ArrayList<Integer>();
				scc.add(component);
//				assign(i, component);
				stack.push(i);
				while(!stack.isEmpty()){
					int cur = stack.pop();
					if (!visited[cur]) continue;
					visited[cur] = false;
					Vertex v = graph[cur];
					component.add(cur);
					for (Integer vertex: v.neighbors){
						stack.push(vertex);
					}
				}
			}	
		}			
	}
	
	
	private void visit(int cur){
		if (visited[cur]) return;
		
		visited[cur] = true;
		Vertex v = graph[cur];
		for (Integer vertex: v.outNeighbors){
			visit(vertex);
		}
		
		order.addFirst(cur);
	}
	
	private void assign(int cur, List<Integer> component){
		if (!visited[cur]) return;
		
		visited[cur] = false;
		Vertex v = graph[cur];
		component.add(cur);
		for (Integer vertex: v.neighbors){
			assign(vertex, component);
		}
	}
	
	public void printSize(int size){
		scc.sort((a,b) -> a.size() > b.size() ? -1 : a.size() == b.size() ? 0 : 1);
		for (int i = 0; i < size; i++){
			System.out.print(scc.get(i).size()+",");
		}
	}
}
