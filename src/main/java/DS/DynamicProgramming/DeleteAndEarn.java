package DS.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
Delete and Earn

You are given an integer array nums. You want to maximize the number of points you get by performing
the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal
to nums[i] - 1 and every element equal to nums[i] + 1. Return the maximum number of points you can earn
by applying the above operation some number of times.

Example 1:
Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.


Example 2:
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104

*/

public class DeleteAndEarn {
    public int[] nums = null;
    Map<Integer, Integer> points = new HashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public int deleteAndEarnV1() {
        int max = 0;
        for(int i : nums){
            points.put(i, points.getOrDefault(i, 0)+i);
            max = Math.max(max, i);
        }

        return recursive(max);
    }

    private int recursive(int num){
        if(num == 0){
            return 0;
        }

        if(num == 1){
            return points.getOrDefault(1, 0);
        }

        if(cache.containsKey(num)){
            return cache.get(num);
        }

        int gain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(recursive(num-1), recursive(num-2)+gain));
        return cache.get(num);
    }

    public int deleteAndEarnV2() {
        int max = 0;
        for(int i : nums){
            points.put(i, points.getOrDefault(i, 0)+ i);
            max = Math.max(max, i);
        }

        int[] dp = new int[max+1];
        dp[1] = points.getOrDefault(1, 0);
        for(int i=2; i<dp.length; i++){
            int gain = points.getOrDefault(i, 0);
            dp[i] = Math.max(dp[i-1], dp[i-2]+gain);
        }

        return dp[max];
    }

}
