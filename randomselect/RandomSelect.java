package randomselect;

// as it never split the array, just keeping the index, the order does not need to be updated
// as the pivot is in the right place for the array;
public class RandomSelect {
	private int[] array;
	
	public RandomSelect(int[] array){
		this.array= array;
	}
	
	public int select(int order){
		int len = array.length;
		return select(0, len, order);
	}
	
	private int select(int start, int len, int order){
		if (len == 1) return array[start];
		int pivot = randomNumber(start, start+len - 1);
		
		swap(pivot, start);
		
		int i = start + 1;
		for (int j = i; j < start + len; j++){
			if (array[j] < array[start]){
				swap(i,j);
				i++;
			}
		}
		pivot = i - 1;
		swap(start, pivot);
		
		if (pivot == order) return array[pivot];
		if (pivot < order) return select(pivot + 1, len - (pivot - start) - 1, order);
		return select(start, pivot - start, order);
		
	}
	
	private int randomNumber(int min, int max){
		int range = max - min + 1;
		return (int) (Math.random() * range) + min ;
	

	}
	
	private void swap(int pos1, int pos2){
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}
}
