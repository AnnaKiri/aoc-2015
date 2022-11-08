package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
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
		int totalRibbon  = 0;
		for (int i = 0; i < presents.size(); i++) {
			String[] onePresent = presents.get(i).split("x");
			int h = Integer.parseInt(onePresent[0]);
			int w = Integer.parseInt(onePresent[1]);
			int l = Integer.parseInt(onePresent[2]);
			
			int maxValue = Math.max(h, Math.max(w, l));		// Math.max сравнивает две переменные и ищет максимальное значение
			
			int wrapper = (h * 2 + w * 2 + l * 2) - maxValue * 2;
			
			int bow = h * w * l;
			
			int ribbonForOnePresent = wrapper + bow;
				
			totalRibbon += ribbonForOnePresent;
		}
		
		return totalRibbon;

	}
}
