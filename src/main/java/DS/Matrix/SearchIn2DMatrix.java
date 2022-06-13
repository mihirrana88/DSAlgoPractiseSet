package DS.Matrix;

import Exception.InvalidInputArgument;

/*
Search a 2D Matrix

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

*/

public class SearchIn2DMatrix {
    int[][] matrix = null;
    public int target;

    public void getInputLength(int row, int column){
        matrix = new int[row][column];
    }

    public void getTarget(int target){
        this.target = target;
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > matrix.length-1 || column > matrix[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        matrix[row][column] = num;
    }

    public boolean searchMatrix() {
        // binary search in first column

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0, end = n-1;
        int row = -1;

        while(start<=end){
            int mid = (start+end)/2;
            if(matrix[mid][0] <= target){
                row = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        if(row==-1) return false;

        // binary search in that row

        start = 0; end = m-1;


        while(start<=end){
            int mid = (start+end)/2;
            if(matrix[row][mid] < target){
                start = mid+1;
            }else if(matrix[row][mid] > target){
                end = mid-1;
            }else return true;
        }
        return false;
    }
}
