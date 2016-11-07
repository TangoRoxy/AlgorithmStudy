import randomselect.RandomSelect;

public class Tester {

	public static void main(String[] args) {
		int[] t1 = {77, 20, 10, 0, 9, 888, 34, 2626, 776, 4564, 234134, 5555};
		
		for (int i = 0; i < 12; i++){
			RandomSelect test = new RandomSelect(t1);
			System.out.println(test.select(i));
		}
	}

}
