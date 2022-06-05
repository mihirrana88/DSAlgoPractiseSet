package DS.Matrix;

import Exception.InvalidInputArgument;

import java.util.Arrays;

/*
Set Matrix Zero

Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set
its entire column and row to 0 and then return the matrix.

Examples 1:

Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

Example 2:

Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row,
1st column and 4th column will be set to 0
*/

public class SetMatrixZero {
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

    public void setZeroes(int [][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] dummy1 =new int[rows];
        int[] dummy2 =new int[cols];
        Arrays.fill(dummy1,-1);
        Arrays.fill(dummy2,-1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }

        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dummy1[i] == 0 || dummy2[j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
