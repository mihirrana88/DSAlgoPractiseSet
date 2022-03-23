package DS.Recursion;

import Exception.InvalidInputArgument;

public class MatrixPath {
    public Integer n = null;
    public Integer m = null;

    public void acceptInputN(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public void acceptInputM(Integer m) throws Exception {
        if(null == m){
            throw new InvalidInputArgument(m);
        }
        this.m = m;
    }

    public int findNumberOfWay(){
        return countWays(n, m);
    }

    public int countWays(int n, int m){
        if(n == 1 || m == 1){
            return 1;
        }
        return countWays(n-1, m) + countWays(n, m-1);
    }
}
