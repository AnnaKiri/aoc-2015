package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		
		final String way = Files.readString(Path.of(path));

		findHousesWithPresent(way);
		
	}
	
	public static void findHousesWithPresent(String way) {
		int x = 0;
		int y = 0;
		Map<String, Integer> map = new HashMap<>();
		map.put((x + ";" + y), 1);
		for (int i = 0; i < way.length(); i++) {
			char step = way.charAt(i);
			switch (step) {
				case '>':
					x++;
					break;
				case '<':
					x--;
					break;
				case '^':
					y++;
					break;
				case 'v':
					y--;
					break;
				default:
					System.out.println("Error1!");
			}
			
			String coord = x + ";" + y;
			if (!map.containsKey(coord)) {
				map.put(coord, 1);
			} else {
				map.put(coord, map.get(coord) + 1);
			}
		}

		System.out.println(map.size());
	
	}
}
