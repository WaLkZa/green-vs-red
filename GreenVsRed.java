import java.util.ArrayList;
import java.util.List;

public class GreenVsRed {
    public static void main(String[] args) {
        int x, y, turns = 0;

        int[][] grid = new int[][] { new int[] { 0, 0, 0 }, new int[] { 1, 1, 1 }, new int[] { 0, 0, 0 } };

        x = 1;
        y = 0;
        turns = 10;
        System.out.println(solveGrid(grid, x, y, turns));

        int[][] grid1 = new int[][] { new int[] { 1, 0, 0, 1 }, new int[] { 1, 1, 1, 1 }, new int[] { 0, 1, 0, 0 },
                new int[] { 1, 0, 1, 0 } };

        x = 2;
        y = 2;
        turns = 15;

        System.out.println(solveGrid(grid1, x, y, turns));
    }

    public static int solveGrid(int[][] grid, int x1, int y1, int n) {
        int[][] possibleIndexes = new int[][] { new int[] { -1, 0 }, new int[] { -1, 1 }, new int[] { 0, 1 },
                new int[] { 1, 1 }, new int[] { 1, 0 }, new int[] { 1, -1 }, new int[] { 0, -1 },
                new int[] { -1, -1 } };

        int generations = 0;

        for (int k = 0; k <= n; k++) {
            List<int[]> changed = new ArrayList<int[]>();

            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    int sumOfCells = 0;

                    for (int j = 0; j < possibleIndexes.length; j++) {
                        try {
                            sumOfCells += grid[row + possibleIndexes[j][0]][col + possibleIndexes[j][1]];
                        } catch (Exception e) {
                        }
                    }

                    if (grid[row][col] == 0 && (sumOfCells == 3 || sumOfCells == 6)
                            || grid[row][col] == 1 && sumOfCells != 2 && sumOfCells != 3 && sumOfCells != 6) {
                        changed.add(new int[] { row, col });
                    }
                }
            }

            if (grid[y1][x1] == 1) {
                generations++;
            }

            for (int i = 0; i < changed.size(); i++) {
                grid[changed.get(i)[0]][changed.get(i)[1]] = grid[changed.get(i)[0]][changed.get(i)[1]] != 0 ? 0 : 1;
            }
        }

        return generations;
    }
}