package randomselect;

public class Inversion {
	
	private int[] array;
	private int[] temp;
	
	public Inversion(int []array){
		this.array = array;
		this.temp = new int[array.length];
	}
	
	public long count(){
		return count(0, array.length);
	}
	
	
	// does not include end
	private long count(int start, int end){
		if (end - start == 1) return 0;
		
		int len = end - start;
		long left, right, split;
		
		left = count(start, start + len/2);
		right = count(start + len/2, end);
		split = countSplit(start, end);
		return left + right + split;
	}

	private long countSplit(int start, int end){
		for (int i = start; i < end; i++){
			temp[i] = array[i];
		}
		
		long result = 0;
		int i = start;
		int k = start;
		int mid = (end - start) / 2 + start;
		int j = mid;
		
		while (i != mid && j != end){
			if (temp [i] > temp[j]){
				result += mid - i;
				array[k++] = temp[j++];
			} else {
				array[k++] = temp[i++];
			}
		}
		
		while (i != mid){
			array[k++] = temp[i++];
		}
		
		while (j != end){
			array[k++] = temp[j++];
		}
		
		return result;
	}
}
