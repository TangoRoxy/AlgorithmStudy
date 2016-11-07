package randomselect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionTester {

	public static void main(String[] args) {
		// it sorts the array as well;
//		int[] t2 = {5, 6};
//		int[] t3 = {1, 2, 3};
//		int[] t5 = {3, 2, 1};
//		int[] t4 = {6, 5, 4, 3};
//		int[] t1 = {4, 5 ,6 , 3, 2 ,1}; //12
//		
//		int[][] t = {t2, t3, t5, t4, t1};
//		for (int i = 0; i < 5; i++){
//			Inversion i1 = new Inversion(t[i]);
//			System.out.println(i1.count());
//		}
		
		int[] hugeArray = new int[100000]; 
		
		try {
		FileInputStream fstream = new FileInputStream("C:\\Users\\xiyao\\Java\\IntegerArray.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		
		for (int i = 0; i < 100000; i++){
			strLine = br.readLine();
			hugeArray[i] = Integer.parseInt(strLine);
		}

		br.close();
		} catch (IOException e){
			e.printStackTrace();
		} 
		Inversion i1 = new Inversion(hugeArray);
		System.out.println(i1.count());
	}

}
