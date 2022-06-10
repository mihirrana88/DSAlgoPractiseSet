package DS.KnapsackDP;

import Exception.InvalidInputArgument;

public class HouseRobberII {
    public int[] nums = null;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public int rob() {
        if(nums.length == 1) return nums[0];

        //need two values, 1. rob first house, 2 rob last house
        //get the max of both
        int[] robFirst = new int[nums.length+1];
        int[] skipFirst = new int[nums.length+1];

        robFirst[0] = 0;
        robFirst[1] = nums[0];

        skipFirst[0] = 0;
        skipFirst[1] = 0;

        for(int i=1; i<nums.length; i++){
            int currentHouse = i+1;
            robFirst[currentHouse] = Math.max(nums[i]+robFirst[currentHouse-2], robFirst[currentHouse-1]);
            skipFirst[currentHouse] = Math.max(nums[i]+skipFirst[currentHouse-2], skipFirst[currentHouse-1]);
        }

        return Math.max(robFirst[nums.length-1], skipFirst[nums.length]);
    }
}
