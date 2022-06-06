package DS.Matrix;

import Exception.InvalidInputArgument;

public class CountNegativesSortedMatrix {
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

    public int countNegatives(){
        int cnt=0;
        int row=0;
        int len=matrix.length;
        int col=matrix[0].length-1;
        while(row<len && col>=0){
            if(matrix[row][col]<0){
                cnt+=len-row;
                col--;
            }
            else{
                row++;
            }
        }
        return cnt;
    }
}
