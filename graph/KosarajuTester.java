package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class KosarajuTester {

	public static void main(String[] args) {
		final int vertexLength = 875714;
//		875714
		final String fileName = "scc.txt";
		Vertex[] g = new Vertex[vertexLength];
		
		for (int i = 0; i < vertexLength; i++){
			g[i] = new Vertex();
		}
		
		try {
			FileInputStream fstream = new FileInputStream("C:\\Users\\xiyao\\Java\\" + fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = br.readLine();
			
			while (strLine != null){
				
				String[] data = strLine.split(" ");
//				for (int j = 1; j < data.length; j++){
//					int neighbor = Integer.parseInt(data[j]);
//					g[i].neighbors.add(neighbor);
//					g[neighbor].outNeighbors.add(i+1);
//				}
				int tail = Integer.parseInt(data[0]) - 1;
				int head = Integer.parseInt(data[1]) - 1;
				g[tail].neighbors.add(head);
				g[head].outNeighbors.add(tail);
				
				strLine = br.readLine();
			}
			br.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println("input done");
		Kosaraju magic = new Kosaraju(g);
		magic.doMagic();
		magic.printSize(5);
		System.out.println("finished");
	}

}
