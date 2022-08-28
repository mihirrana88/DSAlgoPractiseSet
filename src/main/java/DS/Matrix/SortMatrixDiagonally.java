package DS.Matrix;

/*
Sort the Matrix Diagonally

A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost
column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal
starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.


Example 1:
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

Example 2:
Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
 
Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
1 <= mat[i][j] <= 100

*/

public class SortMatrixDiagonally {
    int[][] matrix = null;

    public void getInputLength(int row, int column){
        matrix = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > matrix.length-1 || column > matrix[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        matrix[row][column] = num;
    }

    public int[][] diagonalSort() {
        int[][] res = new int[matrix.length][matrix[0].length];

        int a = matrix.length-1;
        int b = 0;
        while(b < matrix[0].length) {
            sort(matrix, res, a, b);
            if (a < 1) {
                b++;
            } else {
                a--;
            }
        }
        return res;
    }

    public void sum(int[] count) {
        for(int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }
    }

    public void sort(int[][] mat, int[][] res, int a, int b) {
        int[] count = new int[101];
        int i = a, j = b;
        while(i < mat.length && j < mat[0].length) {
            count[mat[i][j]]++;
            i++; j++;
        }
        sum(count);
        i = a; j = b;
        while(i < mat.length && j < mat[0].length) {
            int inx = --count[mat[i][j]] ;
            res[a+inx][b+inx] = mat[i][j];
            i++; j++;
        }
    }
}
