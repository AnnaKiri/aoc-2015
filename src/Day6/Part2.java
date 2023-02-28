package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Part2 {

    final static int ROWS = 1000;
    final static int COLUMNS = 1000;
    static int[][] grid = new int [ROWS][COLUMNS];

    public static void main(String[] args) throws IOException {
        String path = ".\\src\\Day6\\data.txt";
        final String[] instructions = Files.readString(Path.of(path)).lines().toArray(String[]::new);

        for (String str : instructions) {
            final String regex = "^(toggle|turn off|turn on) (\\d+,\\d+) (through) (\\d+,\\d+)$";

            String todo = str.replaceAll(regex, "$1");
            String[] coord1 = str.replaceAll(regex, "$2").split(",");
            String[] coord2 = str.replaceAll(regex, "$4").split(",");

            setUpLights(todo, coord1, coord2);
        }

        long result= Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();

        System.out.println(result);

    }

    public static void setUpLights(String todo, String [] coord1, String [] coord2) {

        int beginX = Integer.parseInt(coord1[0]);
        int beginY = Integer.parseInt(coord1[1]);
        int endX = Integer.parseInt(coord2[0]);
        int endY = Integer.parseInt(coord2[1]);

        for (int i = beginX; i <= endX; i++) {
            for (int j = beginY; j <= endY; j++) {
                switch (todo) {
                    case "turn off":
                        if (grid[i][j] > 0) {
                            grid[i][j] -= 1;
                        }
                        break;
                    case "turn on":
                        grid[i][j] += 1;
                        break;
                    case "toggle":
                        grid[i][j] += 2;
                        break;
                }
            }
        }
    }
}
