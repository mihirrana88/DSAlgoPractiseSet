package DS.Matrix;

import Exception.InvalidInputArgument;

public class SpiralMatrixII {
    public int n = 0;

    public void getInputNumber(int n){
        this.n = n;
    }

    public int[][] generateMatrix() {
        int[][] result = new int[n][n];
        int cnt = 1;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int row = 0;
        int col = 0;
        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            // change direction if next cell is non zero
            if (result[r][c] != 0) d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }
        return result;
    }

    public int[][] generateMatrix2(){
        int rowBegin=0;
        int rowEnd=n-1;
        int colBegin=0;
        int colEnd=n-1;

        int[] spiral = new int[rowEnd*colEnd];
        int[][] spiralMatrix = new int[n][n];

        int cursor = 1;

        while (rowBegin<=rowEnd && colBegin<=colEnd)
        {
            //left to right
            for(int i=colBegin;i<=colEnd;i++)
            {
                spiralMatrix[rowBegin][i] = cursor;
                cursor++;
            }

            rowBegin++;
            if(rowBegin > rowEnd ) break;

            //top to buttom
            for(int i=rowBegin;i<=rowEnd;i++)
            {
                spiralMatrix[i][colEnd] = cursor;
                cursor++;
            }
            colEnd--;
            if(colBegin >  colEnd) break;

            // right to left
            for(int i=colEnd;i>=colBegin;i--)
            {
                spiralMatrix[rowEnd][i] = cursor;
                cursor++;
            }
            rowEnd--;
            if(rowBegin > rowEnd ) break;

            //buttom to top
            for(int i=rowEnd;i>=rowBegin;i--)
            {
                spiralMatrix[i][colBegin] = cursor;
                cursor++;
            }
            colBegin++;
            if(colBegin >  colEnd) break;
        }

        return spiralMatrix;
    }
}
