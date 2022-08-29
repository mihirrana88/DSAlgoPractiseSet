package DS.Matrix;

import Exception.InvalidInputArgument;

/*
Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.


Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

*/

public class NumberOfIslands {
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

    public int numIslands() {
        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    setIsland(grid,i,j);
                }
            }
        }
        return res;
    }

    private void setIsland(char[][] grid, int i, int j){
        if(grid[i][j]=='0')return;
        grid[i][j]='0';
        //move right
        if(i+1<grid.length)setIsland(grid,i+1,j);
        //move down
        if(j+1<grid[i].length)setIsland(grid,i,j+1);
        //move left
        if(i-1>=0)setIsland(grid,i-1,j);
        //move up
        if(j-1>=0)setIsland(grid,i,j-1);
        return;
    }

    public int numberOfIsland(){
        if(null == grid || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        int numberOfIsland = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j] == '1'){
                    numberOfIsland += 1;
                    markAsIsland(grid, i, j, rows, columns);
                }
            }
        }

        return numberOfIsland;
    }

    private void markAsIsland(char[][] grid, int i, int j, int rows, int columns){
        if(grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        if(i-1 >= 0){
            //move up
            markAsIsland(grid, i-1, j, rows, columns);
        }
        if(i+1 < rows){
            //move down
            markAsIsland(grid, i+1, j, rows, columns);
        }
        if(j-1 >= 0){
            //move left
            markAsIsland(grid, i, j-1, rows, columns);
        }
        if(j+1 < columns){
            //move right
            markAsIsland(grid, i, j+1, rows, columns);
        }
    }
}
