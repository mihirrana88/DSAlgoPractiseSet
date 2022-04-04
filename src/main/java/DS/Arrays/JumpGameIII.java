package DS.Arrays;

import Exception.InvalidInputArgument;

public class JumpGameIII {
    public int[] nums = null;
    int start;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getWindowSize(int start){
        this.start = start;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public boolean canReach() {
        return canReach(nums, start);
    }

    private boolean canReach(int[] nums, int start) {
        if(start<0 || start>=nums.length || nums[start]<0)return false;
        if(nums[start]==0)return true;
        nums[start] = -nums[start];
        return (canReach(nums,start+nums[start]) || canReach(nums,start-nums[start]));

    }
}
