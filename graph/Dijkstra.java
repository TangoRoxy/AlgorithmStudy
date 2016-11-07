package graph;

import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra {
	private final int NOT_REACHABLE = 100000;
	private int[] score; // for linear only
	private VertexWeighted[] g;
	private boolean[] visited;
	private PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, (a,b)-> score[a]<score[b]? -1: score[a]==score[b]? 0:1);
	
	public Dijkstra(VertexWeighted[] g){
		int size = g.length;
		score = new int[size];
		visited = new boolean[size];
		for (int i = 0; i < size; i++){
			score[i] = NOT_REACHABLE;
			visited[i] = false;
		}
		this.g = g;
	}
	
	private int min(int a, int b){
		return a < b ? a : b;
	}
	
	public void doMagic(int start){
		score[start] = 0;
		pq.add(start);
		while(!pq.isEmpty()){
			int c = pq.poll();
			if (visited[c]) continue;
			VertexWeighted v = g[c];
			int current_score = score[c];
			int len = v.neighbors.size();
			for (int i = 0; i < len; i++){
				int neighbor = v.neighbors.get(i);
				if (visited[neighbor]) continue;
//				pq.remove(neighbor);
				score[neighbor] = min(score[neighbor], v.distance.get(i) + current_score);
				pq.add(neighbor);
			}
			
			visited[c] = true;
		}
	}
	
	public void printDistance(int dest){
		System.out.print(score[dest - 1]);
	}
	
	public void printDistance(int[] dest){
		int len = dest.length;
		for (int i = 0; i < len; i ++){
			printDistance(dest[i]);
			System.out.print(',');
		}
		System.out.println();
	}
	
	
//	doDFS: source, neighbor_fct (or source must contain neighbor function), todo_fct, stack
	
	// from current point: calculate score of unvisited neighbors, push them to min-heap (if not using heap, then linear scan to find the min); marked current as visited
	// take the min, repeat.
	
	
	// MIN-HEAP -> push vertex into the min-heap, maintain reference to that vertex . Must augment vertex to keep track of the score.
	// 1. linear scan: no additional space, linear
	// 2. min-heap, no deletion: extra space, nlogn
	// 3. min-heap with vertex augmentation: extra space for vertex, nlogn
	
}
