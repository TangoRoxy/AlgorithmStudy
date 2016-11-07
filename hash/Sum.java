package hash;

import java.util.HashSet;
import java.util.Set;

public class Sum {
	private Set<Long> source;
	private Set<Integer> target = new HashSet<Integer>();
	private int start;
	private int end;
	
	public Sum(Set<Long> source, int start, int end){
		this.source = source;
		this.start = start;
		this.end = end;
	}
	
	public void populate(){
		for (long e: source){
			for (int i = start; i <= end; i++){
				if (2 * e == i) continue;
				if (source.contains(i - e)){
					target.add(i);
				}
			}
		}
	}
	
	public int getSize(){
		return target.size();
	}
}
