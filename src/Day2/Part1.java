package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		List<String> presents = new ArrayList<>();
		while (scan.hasNextLine()) {
			presents.add(scan.nextLine());
		}
				
		scan.close();	
		
		System.out.println(findAmountWrappingPaper(presents));

	}
	
	public static int findAmountWrappingPaper(List<String> presents) {
		int totalArea = 0;
		int presentArea = 0;
		for (int i = 0; i < presents.size(); i++) {
			String[] onePresent = presents.get(i).split("x");
			int h = Integer.parseInt(onePresent[0]);
			int w = Integer.parseInt(onePresent[1]);
			int l = Integer.parseInt(onePresent[2]);
			
			int area1 = h * w;
			int area2 = h * l;
			int area3 = w * l;
				
			int minArea = Math.min(area1, Math.min(area2, area3));		// Math.min сравнивает две переменные и ищет минимальное значение
			
			presentArea = area1 * 2 + area2 * 2 + area3 * 2 + minArea;
			totalArea += presentArea;
		}
		
		return totalArea;

	}
}
