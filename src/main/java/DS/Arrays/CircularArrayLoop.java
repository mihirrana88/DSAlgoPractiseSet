package DS.Arrays;

import Exception.InvalidInputArgument;

public class CircularArrayLoop {
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

    public boolean circularArrayLoop() throws Exception {

        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        for (int i = 0; i < nums.length; i++) {
            float direction = Math.signum(nums[i]);
            int slow = i;
            int fast = i;

            do {
                slow = getNextIndex(nums, direction, slow);
                fast = getNextIndex(nums, direction, fast);
                if (fast != -1)
                    fast = getNextIndex(nums, direction, fast);
                if (fast == -1 || nums[slow] == 0 || nums[fast] == 0)
                    break;
            } while (slow != fast);

            if (slow != -1 && slow == fast)
                return true;
            nums[i] = 0;
        }
        return false;
    }

    private int getNextIndex(int[] nums, float direction, int i) {
        float currentDirection = Math.signum(nums[i]);
        if (currentDirection * direction < 0)
            return -1;
        int n = nums.length;
        int nextIndex = (i + nums[i]) % n;
        if (nextIndex < 0)
            nextIndex += n;
        return nextIndex == i ? -1 : nextIndex;
    }
}
