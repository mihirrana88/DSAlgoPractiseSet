package DS.Matrix;

import Exception.InvalidInputArgument;

public class WhereWillTheBallFall {
    int[][] grid = null;

    public void getInputLength(int row, int column){
        grid = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > grid.length-1 || column > grid[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        grid[row][column] = num;
    }

    public int[] findBall() {
        int[] ans=new int[grid[0].length];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=find(0,i,grid,grid.length,grid[0].length);
        }
        return ans;
    }
    public int find(int i,int j,int[][] g,int n,int m)
    {

        if(g[i][j]==1)
        {
            if(j+1<m && g[i][j+1]!=-1)
            {
                if(i==n-1) return j+1;
                return find(i+1,j+1,g,n,m);
            }
            else return -1;
        }
        else
        {
            if((j-1)>=0 && g[i][j-1]!=1)
            {
                if(i==n-1) return j-1;
                return find(i+1,j-1,g,n,m);
            }
            else return -1;
        }
    }
}
