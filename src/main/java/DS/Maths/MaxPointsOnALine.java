package DS.Maths;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.HashMap;

/*
Max Points on a Line

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
return the maximum number of points that lie on the same straight line.

Example 1:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Example 2:
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 
Constraints:

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.

*/

public class MaxPointsOnALine {
    int[][] points = null;

    int n;
    HashMap<Pair<Integer, Integer>, Integer> lines = new HashMap<Pair<Integer, Integer>, Integer>();
    int horizontal_lines;

    public void getInputLength(int row, int column){
        points = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > points.length-1 || column > points[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        points[row][column] = num;
    }

    /**
     * To avoid the precision issue with float/double numbers, using a pair of co-prime numbers to
     * represent the slope.
     */
    private Pair<Integer, Integer> slope_coprime(int x1, int y1, int x2, int y2) {
        int deltaX = x1 - x2, deltaY = y1 - y2;
        if (deltaX == 0)
            return new Pair<>(0, 0);
        else if (deltaY == 0)
            return new Pair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        else if (deltaX < 0) {
            deltaX = -deltaX;
            deltaY = -deltaY;
        }
        Integer gcd = BigInteger.valueOf(deltaX).gcd(BigInteger.valueOf(deltaY)).intValue();

        return new Pair<Integer, Integer>(deltaX / gcd, deltaY / gcd);
    }

    public Pair<Integer, Integer> add_line(int i, int j, int count, int duplicates) {
        /*
         * Add a line passing through i and j points. Update max number of points on a line
         * containing point i. Update a number of duplicates of i point.
         */
        // rewrite points as coordinates
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        // add a duplicate point
        if ((x1 == x2) && (y1 == y2))
            duplicates++;
            // add a horisontal line : y = const
        else if (y1 == y2) {
            horizontal_lines += 1;
            count = Math.max(horizontal_lines, count);
        }
        // add a line : x = slope * y + c
        // only slope is needed for a hash-map
        // since we always start from the same point
        else {
            Pair<Integer, Integer> slope = this.slope_coprime(x1, y1, x2, y2);
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(lines.get(slope), count);
        }
        return new Pair(count, duplicates);
    }

    public int max_points_on_a_line_containing_point_i(int i) {
        /*
         * Compute the max number of points for a line containing point i.
         */
        // init lines passing through point i
        lines.clear();
        horizontal_lines = 1;
        // One starts with just one point on a line : point i.
        int count = 1;
        // There is no duplicates of a point i so far.
        int duplicates = 0;

        // Compute lines passing through point i (fixed)
        // and point j.
        // Update in a loop the number of points on a line
        // and the number of duplicates of point i.
        for (int j = i + 1; j < n; j++) {
            Pair<Integer, Integer> p = add_line(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }
        return count + duplicates;
    }


    public int maxPoints() {
        // If the number of points is less than 3
        // they are all on the same line.
        n = points.length;
        if (n < 3)
            return n;

        int max_count = 1;
        // Compute in a loop a max number of points
        // on a line containing point i.
        for (int i = 0; i < n - 1; i++)
            max_count = Math.max(max_points_on_a_line_containing_point_i(i), max_count);
        return max_count;
    }
}
