package DS.Matrix;

import Exception.InvalidInputArgument;

/*
Kth Smallest Element in a Sorted Matrix

Given an n x n matrix where each of the rows and columns is sorted in ascending order,
return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:
Input: matrix = [[-5]], k = 1
Output: -5

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2


Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an
interview but you may find reading this paper fun.

*/

public class KthSmallestElementSortedMatrix {
    int[][] matrix = null;
    int k;

    public void getInputLength(int row, int column){
        matrix = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > matrix.length-1 || column > matrix[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        matrix[row][column] = num;
    }

    public void getK(int k){
        this.k = k;
    }

    public int kthSmallest() {
        int n= matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while(low < high){
            int mid = low + (high - low)/2;
            int count = lessEqual(matrix,mid);
            if(count < k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    public int lessEqual(int[][] matrix, int target){
        int count = 0 , len = matrix.length, i = len-1, j=0;

        while(i >=0 && j<len){
            if(matrix[i][j] > target){
                i--;
            }
            else
            {
                count = count + i +1;
                j++;
            }
        }
        return count;
    }

}
