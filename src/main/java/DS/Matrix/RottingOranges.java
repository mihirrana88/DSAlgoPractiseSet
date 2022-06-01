package DS.Matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RottingOranges {
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

    public int orangesRotting() {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] time=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(time[i],-1);

        Deque<Pair> q=new ArrayDeque<>();   //Queue stores row and column of rotten oranges

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==2)
                {
                    q.add(new Pair(i,j));
                }
            }
        }

        Pair last=new Pair(-1,-1);

        if(!q.isEmpty())
            last=q.getLast();

        int t=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x=p.x;
            int y=p.y;

            time[x][y]=t;
            //Checking four directions and if adjacent  element is 1 then add it to the queue

            if(x>0 && matrix[x-1][y] == 1 )
            {
                matrix[x-1][y]=2;
                q.add(new Pair(x-1,y));
            }

            if(y>0 && matrix[x][y-1] == 1 )
            {
                matrix[x][y-1]=2;
                q.add(new Pair(x,y-1));
            }

            if(x<n-1 && matrix[x+1][y] == 1 )
            {
                matrix[x+1][y]=2;
                q.add(new Pair(x+1,y));
            }

            if(y<m-1 && matrix[x][y+1] == 1 )
            {
                matrix[x][y+1]=2;
                q.add(new Pair(x,y+1));
            }

            if(x==last.x && y==last.y){
                t++;
                if(!q.isEmpty()) last=q.getLast();
            }
        }

        int max=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 1 && time[i][j] == -1){
                    return -1;
                }
                max=Math.max(max,time[i][j]);
            }
        }

        return max;
    }

    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}


