package DS.Maths;

import Exception.InvalidInputArgument;

/*
Rectangle Area

Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area
covered by the two rectangles.

The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).

The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

Example 1:
Rectangle Area
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45

Example 2:
Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
Output: 16

Constraints:

-104 <= ax1 <= ax2 <= 104
-104 <= ay1 <= ay2 <= 104
-104 <= bx1 <= bx2 <= 104
-104 <= by1 <= by2 <= 104

*/

public class RectangleArea {
    public Integer ax1 = null;
    public Integer ay1 = null;
    public Integer ax2 = null;
    public Integer ay2 = null;
    public Integer bx1 = null;
    public Integer by1 = null;
    public Integer bx2 = null;
    public Integer by2 = null;

    public void acceptInputAx1(Integer ax1) throws Exception {
        if(null == ax1){
            throw new InvalidInputArgument(ax1);
        }
        this.ax1 = ax1;
    }
    public void acceptInputAy1(Integer ay1) throws Exception {
        if(null == ay1){
            throw new InvalidInputArgument(ay1);
        }
        this.ay1 = ay1;
    }
    public void acceptInputAx2(Integer ax2) throws Exception {
        if(null == ax2){
            throw new InvalidInputArgument(ax2);
        }
        this.ax2 = ax2;
    }
    public void acceptInputAy2(Integer ay2) throws Exception {
        if(null == ay2){
            throw new InvalidInputArgument(ay2);
        }
        this.ay2 = ay2;
    }
    public void acceptInputBx1(Integer bx1) throws Exception {
        if(null == bx1){
            throw new InvalidInputArgument(bx1);
        }
        this.bx1 = bx1;
    }
    public void acceptInputBy1(Integer by1) throws Exception {
        if(null == by1){
            throw new InvalidInputArgument(by1);
        }
        this.by1 = by1;
    }
    public void acceptInputBx2(Integer bx2) throws Exception {
        if(null == bx2){
            throw new InvalidInputArgument(bx2);
        }
        this.bx2 = bx2;
    }
    public void acceptInputBy2(Integer by2) throws Exception {
        if(null == by2){
            throw new InvalidInputArgument(by2);
        }
        this.by2 = by2;
    }

    public int computeArea() {
        int areaOfA = (ay2 - ay1) * (ax2 - ax1);
        int areaOfB = (by2 - by1) * (bx2 - bx1);

        // calculate x overlap
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;

        // calculate y overlap
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;

        int areaOfOverlap = 0;
        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        if (xOverlap > 0 && yOverlap > 0) {
            areaOfOverlap = xOverlap * yOverlap;
        }

        // areaOfOverlap is counted twice when in the summation of
        // areaOfA and areaOfB, so we need to subtract it from the
        // total, to get the toal area covered by both the rectangles
        int totalArea = areaOfA + areaOfB - areaOfOverlap;

        return totalArea;
    }
}
