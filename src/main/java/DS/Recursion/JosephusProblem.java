package DS.Recursion;

import Exception.InvalidInputArgument;

public class JosephusProblem {
    public Integer n = null;
    public Integer k = null;

    public void acceptInputN(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public void acceptInputK(Integer k) throws Exception {
        if(null == k){
            throw new InvalidInputArgument(k);
        }
        this.k = k;
    }

    public int findWinner(){
        return findWinner(n, k);
    }

    public int findWinner(int n, int k){
        if(n==1){
            return 1;
        }

        return (findWinner(n-1, k) + k - 1) % n + 1;
    }
}
