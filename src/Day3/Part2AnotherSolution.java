package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Part2AnotherSolution {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		
		final String way = Files.readString(Path.of(path));

		findHousesWithPresent(way);
		
	}
	
	public static void findHousesWithPresent(String way) {
		int x = 0;
		int y = 0;
		int x2 = 0;
		int y2 = 0;
		
		Map<String, Integer> map = new HashMap<>();
		map.put((x + ";" + y), 1);
		for (int i = 0; i < way.length(); i++) {
			char step = way.charAt(i);
			boolean roboSanta = (i % 2 == 0);

			switch (step) {
				case '>' -> {if (roboSanta) x2++; else x++;}
				case '<' -> {if (roboSanta) x2--; else x--;}
				case '^' -> {if (roboSanta) y2++; else y++;}
				case 'v' -> {if (roboSanta) y2--; else y--;}
				default ->	System.out.println("Error1!");
			}
			
			String coord = roboSanta ? x + ";" + y : x2 + ";" + y2;
			if (!map.containsKey(coord)) {
				map.put(coord, 1);
			} else {
				map.put(coord, map.get(coord) + 1);
			}
		}

		System.out.println(map.size());
	
	}
}
