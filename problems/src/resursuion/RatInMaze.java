package resursuion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RatInMaze {
    private static int[][] visited;
    private List<String> solve(int[][] input) {
        List<String> result = new ArrayList<>();
        findPath(input, result, "", 0, 0);
        return result;
    }
    private void findPath(int[][] input, List<String> result, String currentPath, int x, int y) {
        if (x == input.length - 1 && y == input[0].length - 1) {
            result.add(currentPath);
            return;
        }
        else {
            visited[x][y] = 1;
        }
        //Up
        if (x - 1 > 0 && visited[x - 1][y] == 0 && input[x - 1][y] == 1) {
            findPath(input, result, currentPath+ "U", x - 1, y);
        }
        //Down
        if (x + 1 < input.length && visited[x + 1][y] == 0 && input[x + 1][y] == 1) {
            findPath(input, result, currentPath + "D", x + 1, y);
        }
        //Left
        if (y - 1 > 0 && visited[x][y - 1] == 0 && input[x][y - 1] == 1) {
            findPath(input, result, currentPath + "L", x, y - 1);
        }
        //Right
        if (y + 1 < input[0].length && visited[x][y + 1] == 0 && input[x][y + 1] == 1) {
            findPath(input, result, currentPath + "R", x, y + 1);
        }
        visited[x][y] = 0;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] input = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        visited = new int[input.length][input[0].length];
        RatInMaze ratInMaze = new RatInMaze();
        List<String> result = ratInMaze.solve(input);
        System.out.println("-----------------------------");
        for (String eachPath: result) {
            System.out.println(eachPath);
        }
    }
}
