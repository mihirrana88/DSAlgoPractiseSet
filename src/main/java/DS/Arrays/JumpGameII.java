package DS.Arrays;

import Exception.InvalidInputArgument;

public class JumpGameII {
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

    public int count() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        // Within previous one's jump range, the farest place you can jump each time
        int far = 0;
        // used to store previous farest jump range
        int farEnd = 0;
        // how many times you have jumped
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if(farEnd == i) {
                // if reach the farest range of previous jump,
                // need to set target range to new "far"
                // count + 1, and reset far
                count++;
                farEnd = far;
                far = 0;
            }
        }
        return count;
    }
}
