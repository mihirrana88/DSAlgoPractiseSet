package DS.Matrix;

import java.util.HashSet;
import java.util.Set;

/*
Number of Distinct Islands (identical)

Given a non-empty 2D array grid of 0's and 1's, an island is a group of1's (representing land)
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid
are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if
and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:

11000
11000
00011
00011

Given the above grid map, return 1.

Example 2:

11011
10000
00001
11011

Given the above grid map, return 3.

Notice that:

11

1

and

 1

11

are considered same island shapes, because we do consider reflection / rotation.

Note: The length of each dimension in the given grid does not exceed 50.
*/

public class NumberOfDistinctIslands {
    char[][] grid = null;

    public void getInputLength(int row, int column){
        grid = new char[row][column];
    }

    public void acceptInput(char c, int row, int column){
        if(row < 0 || column < 0 || row > grid.length-1 || column > grid[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        grid[row][column] = c;
    }

    public int numDistinctIslands(int[][] grid){
        if(null == grid || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        Set<Integer> islands = new HashSet<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j] == 1){
                    islands.add(calculateAreaOfIsland(grid, i, j, rows, columns));
                }
            }
        }

        return islands.size();
    }

    public int calculateAreaOfIsland(int[][] grid, int i, int j, int rows, int columns){
        if(i < 0 || j < 0 || i >= rows || j >= columns || grid[i][j] == 0){
            return 0;
        }

        return 1 + calculateAreaOfIsland(grid, i-1, j, rows, columns)
                + calculateAreaOfIsland(grid, i+1, j, rows, columns)
                + calculateAreaOfIsland(grid, i, j-1, rows, columns)
                + calculateAreaOfIsland(grid, i, j+1, rows, columns);
    }
}
