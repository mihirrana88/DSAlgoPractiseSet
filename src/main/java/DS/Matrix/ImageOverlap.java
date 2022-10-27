package DS.Matrix;

/*
Image Overlap

You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary
matrix has only 0s and 1s as values.

We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number
of units. We then place it on top of the other image. We can then calculate the overlap by counting the
number of positions that have a 1 in both images.

Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of
the matrix borders are erased.

Return the largest possible overlap.

Example 1:
Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We translate img1 to right by 1 unit and down by 1 unit.

The number of positions that have a 1 in both images is 3 (shown in red).

Example 2:
Input: img1 = [[1]], img2 = [[1]]
Output: 1

Example 3:
Input: img1 = [[0]], img2 = [[0]]
Output: 0

Constraints:

n == img1.length == img1[i].length
n == img2.length == img2[i].length
1 <= n <= 30
img1[i][j] is either 0 or 1.
img2[i][j] is either 0 or 1.

*/

public class ImageOverlap {
    int[][] img1 = null;
    int[][] img2 = null;

    public void getInputLength1(int row, int column){
        img1 = new int[row][column];
    }

    public void acceptInput1(int num, int row, int column){
        if(row < 0 || column < 0 || row > img1.length-1 || column > img1[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        img1[row][column] = num;
    }

    public void getInputLength2(int row, int column){
        img2 = new int[row][column];
    }

    public void acceptInput2(int num, int row, int column){
        if(row < 0 || column < 0 || row > img2.length-1 || column > img2[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        img2[row][column] = num;
    }

    public int largestOverlap() {
        int res = 0;
        int N = img1.length;
        int[][] count = new int[N * 2][N * 2];
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                if(img1[i][j] == 0) continue;

                for(int m = 0; m < N; m ++) {
                    for(int n = 0; n < N; n ++) {
                        if(img2[m][n] == 0) continue;
                        res = Math.max(res, ++ count[N + i - m][N + j - n]);
                    }
                }
            }
        }
        return res;
    }
}
