package DS.Matrix;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
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

    public int[] spiralOrder() throws Exception{
        if(null == matrix || matrix.length == 0){
            throw new InvalidInputArgument(matrix);
        }

        int rowBegin=0;
        int rowEnd=matrix.length-1;
        int colBegin=0;
        int colEnd=matrix[0].length-1;

        int[] spiral = new int[matrix.length*matrix[0].length];
        int cursor = 0;

        if(matrix.length==0)
            return spiral;

        while (true)
        {
            //left to right
            for(int i=colBegin;i<=colEnd;i++)
            {
                spiral[cursor] = matrix[rowBegin][i];
                cursor++;
            }
            rowBegin++;
            if(rowBegin > rowEnd ) break;

            //top to buttom
            for(int i=rowBegin;i<=rowEnd;i++)
            {
                spiral[cursor] = matrix[i][colEnd];
                cursor++;
            }
            colEnd--;
            if(colBegin >  colEnd) break;

            // right to left
            for(int i=colEnd;i>=colBegin;i--)
            {
                spiral[cursor] = matrix[rowEnd][i];
                cursor++;
            }
            rowEnd--;
            if(rowBegin > rowEnd ) break;

            //buttom to top
            for(int i=rowEnd;i>=rowBegin;i--)
            {
                spiral[cursor] = matrix[i][colBegin];
                cursor++;
            }
            colBegin++;
            if(colBegin >  colEnd) break;
        }

        return spiral;
    }

    public List<Integer> spiralOrder2() throws Exception {
        if(null == matrix || matrix.length == 0){
            throw new InvalidInputArgument(matrix);
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;

        List<Integer> spiralOrderList = new ArrayList<>();

        while (true){
            for (int i=columnStart; i<=columnEnd; i++){
                spiralOrderList.add(matrix[rowStart][i]);
            }
            rowStart++;
            if (rowStart > rowEnd){
                break;
            }
            for (int i=rowStart; i<=rowEnd; i++){
                spiralOrderList.add(matrix[i][columnEnd]);
            }
            columnEnd--;
            if (columnStart > columnEnd){
                break;
            }
            for (int i=columnEnd; i>=columnStart; i--){
                spiralOrderList.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if (rowStart > rowEnd){
                break;
            }
            for (int i=rowEnd; i>=rowStart; i--){
                spiralOrderList.add(matrix[i][columnStart]);
            }
            columnStart++;
            if(columnStart > columnEnd){
                break;
            }
        }

        return spiralOrderList;
    }
}
