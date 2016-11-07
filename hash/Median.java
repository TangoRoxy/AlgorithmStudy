package hash;

import java.util.PriorityQueue;

public class Median {
	PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	PriorityQueue<Integer> max = new PriorityQueue<Integer>((a,b)-> a>b ? -1: a==b ? 0 : 1);
	
}
