package DS.DynamicProgramming;

import java.util.Arrays;

import Exception.InvalidInputArgument;

public class TallestBillboard {
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

    public int tallestBillboard() throws Exception {

        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }


        int n = nums.length;
        int maxDiff = 0;
        for (int rod : nums) {
            maxDiff += rod;
        }
        int[] dp = new int[maxDiff+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int i = 0;i < n;i++) {
            int l = nums[i];
            int[] dp_old = new int[maxDiff+1];
            for (int k = 0;k < maxDiff+1;k++) {
                dp_old[k] = dp[k];
            }
            for (int diff = 0;diff < maxDiff+1;diff++) {
                if (dp_old[diff] == -1) {
                    continue;
                }
                if (diff + l <= maxDiff) {
                    dp[diff+l] = Math.max(dp[diff+l],dp_old[diff]+l);
                }

                if (l-diff >= 0) {
                    dp[l-diff] = Math.max(dp[l-diff],l + dp_old[diff]-diff);
                } else {
                    dp[diff-l] = Math.max(dp[diff-l],dp_old[diff]);
                }
            }
        }
        return dp[0];
    }
}
