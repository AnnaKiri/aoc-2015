package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Part2 {
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
			if (i % 2 != 0) {
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
				
				String coord1 = x + ";" + y;
				if (!map.containsKey(coord1)) {
					map.put(coord1, 1);
				} else {
					map.put(coord1, map.get(coord1) + 1);
				}
			} else {
				switch (step) {
				case '>':
					x2++;
					break;
				case '<':
					x2--;
					break;
				case '^':
					y2++;
					break;
				case 'v':
					y2--;
					break;
				default:
					System.out.println("Error1!");
			}
			
				String coord2 = x2 + ";" + y2;
				if (!map.containsKey(coord2)) {
					map.put(coord2, 1);
				} else {
					map.put(coord2, map.get(coord2) + 1);
				}
			}
		}

		System.out.println(map.size());
	
	}
}
