package DS.Maths;

import Exception.InvalidInputArgument;

/*
Mirror Reflection

There is a special square room with mirrors on each of the four walls. Except for the southwest corner,
there are receptors on each of the remaining corners, numbered 0, 1, and 2.

The square room has walls of length p and a laser ray from the southwest corner first meets the east wall
at a distance q from the 0th receptor.

Given the two integers p and q, return the number of the receptor that the ray meets first.

The test cases are guaranteed so that the ray will meet a receptor eventually.

Example 1:
Input: p = 2, q = 1
Output: 2
Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.

Example 2:
Input: p = 3, q = 1
Output: 1


Constraints:

1 <= q <= p <= 1000

*/

public class MirrorReflection {
    public Integer p = null;
    public Integer q = null;

    public void acceptInputNumber1(Integer p) throws Exception {
        if(null == p){
            throw new InvalidInputArgument(p);
        }
        this.p = p;
    }

    public void acceptInputNumber2(Integer q) throws Exception {
        if(null == q){
            throw new InvalidInputArgument(q);
        }
        this.q = q;
    }

    public int mirrorReflection() {
        while ((p%2==0) && (q%2==0)) {
            p/=2;
            q/=2;
        }
        //both p qnd q can't be even
        if((p%2)==0 && (q%2)!=0){
            return 2;//when p is even and q is odd
        }
        if((p%2)!=0 && (q%2)!=0){
            return 1;// when p is odd and q is odd
        }
        return 0;// when p is odd and q is even
    }
}
