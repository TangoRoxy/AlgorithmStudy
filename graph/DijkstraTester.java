package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class DijkstraTester {

	public static void main(String[] args) {
		final int GRAPHSIZE = 200;
		final String PATH = "C:\\Users\\xiyao\\Java\\dijk.txt";
		final int[] dest = {7,37,59,82,99,115,133,165,188,197};
		final int start = 1;
		
		VertexWeighted[] g = new VertexWeighted[GRAPHSIZE];
		
		for (int i = 0; i < GRAPHSIZE; i++){
			g[i] = new VertexWeighted();
		}
		
		try {
			FileInputStream fstream = new FileInputStream(PATH);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = br.readLine();
//			Pattern whitespace = Pattern.compile("\s");
			while (strLine != null){
				
				String[] data = strLine.split("\t"); // regex of white space
				int tail = Integer.parseInt(data[0]) - 1;
				for (int i = 1; i < data.length; i++){
					String[] head = data[i].split(",");
					int vertex = Integer.parseInt(head[0]) - 1;
					int weight = Integer.parseInt(head[1]);
					g[tail].neighbors.add(vertex);
					g[tail].distance.add(weight);
				}				
				strLine = br.readLine();
			}
			br.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println("input done");
		Dijkstra d = new Dijkstra(g);
		d.doMagic(start - 1);
		d.printDistance(dest);
	}

}
