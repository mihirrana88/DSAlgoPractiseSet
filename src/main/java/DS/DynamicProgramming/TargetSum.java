package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

/*
Target Sum

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer
in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build
the expression "+2-1". Return the number of different expressions that you can build, which evaluates to target.


Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:
Input: nums = [1], target = 1
Output: 1
 
Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000

*/

public class TargetSum {
    public int[] nums = null;
    int target;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getWindowSize(int target){
        this.target = target;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public int findTargetSumWays() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }
        int n=nums.length;
        return solUtil(nums,target,n-1);
    }

    private int solUtil(int[] nums,int target,int index){

        if(index==0) {

            if(target-nums[0]==0 || nums[0]+target==0) {

                /* Here we are checking this becoz, it might happen we have already reached
                our target, so adding this value i.e 0, will create 2 possiblity. */

                if(nums[0]==0) return 2;
                return 1;
            }
            else return 0;
        }

        int add=solUtil(nums,target+nums[index],index-1);

        int sub=solUtil(nums,target-nums[index],index-1);

        return add+sub;
    }
}
