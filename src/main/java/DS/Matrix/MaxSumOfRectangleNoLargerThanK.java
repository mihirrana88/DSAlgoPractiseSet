package DS.Matrix;

import Exception.InvalidInputArgument;

/*
Max Sum of Rectangle No Larger Than K

Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such
that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

Example 1:
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number
no larger than k (k = 2).

Example 2:
Input: matrix = [[2,2,-1]], k = 3
Output: 3

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-105 <= k <= 105

*/

public class MaxSumOfRectangleNoLargerThanK {
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

    public int maxSumSubmatrix() {

        int n=matrix.length;
        int m=matrix[0].length;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

            int a[] = new int[m];

            for(int j=i;j<n;j++){

                for(int x=0;x<m;x++){

                    a[x]+=matrix[j][x];
                }

                int sum=helper(a,k);
                max=Math.max(max,sum);
            }
        }

        return max;
    }

    public int helper(int a[], int k){

        int ans=Integer.MIN_VALUE;

        for(int i=0;i<a.length;i++){

            int s=0;

            for(int j=i;j<a.length;j++){

                s+=a[j];
                if(s<=k)
                    ans=Math.max(ans,s);

            }
        }

        return ans;
    }
}
