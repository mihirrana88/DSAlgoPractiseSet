package DS.Arrays;

import Exception.InvalidInputArgument;

public class StockBuyAndSellV2 {
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

    public int getMaximumProfitPossible() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        if (nums.length == 1){
            return 0;
        }

        int maxProfit = 0;
        for(int i=1; i< nums.length; i++){
            if(nums[i] > nums[i-1]){
                maxProfit += nums[i] - nums[i-1];
            }
        }

        return maxProfit;
    }
}
