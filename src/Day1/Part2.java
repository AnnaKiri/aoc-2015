package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		try {
			Scanner scan = new Scanner(file);
			
			String floor = scan.nextLine();
			
			scan.close();
			
			int result = 0;
			int position = 0;
			for (int i = 0; i < floor.length(); i++) {
				if (floor.charAt(i) == '(') {
					result ++;
				} else {
					result --;
				}
				
				if (result == -1) {
					position = i + 1;
					break;
				}
			}
			
			System.out.println(position);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
}