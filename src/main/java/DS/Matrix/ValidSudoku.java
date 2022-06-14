package DS.Matrix;

import Exception.InvalidInputArgument;

/*
Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:
Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true


Example 2:
Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false

Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.

*/

public class ValidSudoku {
    char[][] board = null;

    public void getInputLength(int row, int column){
        board = new char[row][column];
    }

    public void acceptInput(char ch, int row, int column){
        if(row < 0 || column < 0 || row > board.length-1 || column > board[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        board[row][column] = ch;
    }

    public boolean isValidSudoku() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != '.' && !isValid(board,i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isValid(char[][] board, int i, int j) {
        char v = board[i][j];
        board[i][j] = '.';
        for(int l = 0; l < 9; l++) if(board[i][l] == v) return false;
        for(int l = 0; l < 9; l++) if(board[l][j] == v) return false;
        for(int l = 0; l < 9; l++) {
            int x = (3 * (i/3)) + l/3;
            int y = (3 * (j/3)) + l%3;
            if(board[x][y] == v) return false;
        }
        board[i][j] = v;
        return true;
    }
}
