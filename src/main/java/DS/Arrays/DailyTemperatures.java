package DS.Arrays;

import Exception.InvalidInputArgument;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures {
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

    public int[] dailyTemperatures() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        int[] result = new int[nums.length];
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();

        for(int i=nums.length-1; i>=0; i--){

            if(!stack.isEmpty() && stack.peek().getValue() <= nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i] = 0;
            }else {
                result[i] = stack.peek().getKey() - i;
            }

            stack.push(new AbstractMap.SimpleEntry<Integer, Integer>(i, nums[i]));
        }

        return result;
    }
}
