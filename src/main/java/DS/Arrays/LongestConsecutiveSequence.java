package DS.Arrays;

import Exception.InvalidInputArgument;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
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

    public int longestConsecutiveSequence() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        Set<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }

        int longestSequence = 0;

        for(int num : numSet){
            if(!numSet.contains(num-1)){
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum+1)){
                    currentNum += 1;
                    currentLength += 1;
                }

                longestSequence = Math.max(currentLength, longestSequence);
            }
        }

        return longestSequence;
    }
}
