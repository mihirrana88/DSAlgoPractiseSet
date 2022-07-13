package DS.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

*/

public class MergeIntervals {
    int[][] intervals = null;

    public void getInputLength(int row, int column){
        intervals = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > intervals.length-1 || column > intervals[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        intervals[row][column] = num;
    }

    public int[][] merge() {
        //sorting
        //so that we can perform the task linearly
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                if(a[0]==b[0])
                    return Integer.compare(a[1],b[1]);
                return Integer.compare(a[0],b[0]);
            }
        });
        /*
        for(int i=0;i<intervals.length;i++)
            System.out.println(intervals[i][0]+" "+intervals[i][1]);
        */
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int i=0;
        while(i<intervals.length){

            int start=intervals[i][0];//storing start
            int end=intervals[i][1];
            i++;
            while(i<intervals.length && intervals[i][0]<=end){
                if(intervals[i][1]>end)//making sure range is not shrinking
                    end=intervals[i][1];
                i++;
            }
            List<Integer> temp=new ArrayList<Integer>();
            temp.add(start);
            temp.add(end);
            list.add(temp);

        }
        //System.out.println(list);
        int arr[][]=new int[list.size()][2];
        i=0;
        for(List<Integer> l:list){
            arr[i][0]=l.get(0);
            arr[i][1]=l.get(1);
            i++;
        }
        return arr;
    }
}
