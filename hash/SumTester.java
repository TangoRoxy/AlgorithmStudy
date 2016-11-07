package hash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SumTester {

	public static void main(String[] args) {
		final String PATH = "C:\\Users\\xiyao\\Java\\hash.txt";
		final int start = -10000;
		final int end = 10000;
		
		Set<Long> set = new HashSet<Long>();
		try {
			FileInputStream fstream = new FileInputStream(PATH);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = br.readLine();
			while (strLine != null){
				
				set.add(Long.parseLong(strLine));			
				strLine = br.readLine();
			}
			br.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println("input done");
		Sum sum = new Sum(set, start, end);
		sum.populate();
		System.out.println(sum.getSize());
	}

}
