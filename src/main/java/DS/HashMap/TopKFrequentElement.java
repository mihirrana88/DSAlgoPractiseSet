package DS.HashMap;

import Exception.InvalidInputArgument;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

*/

public class TopKFrequentElement {
    public int[] nums = null;
    int k;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getWindowSize(int k){
        this.k = k;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public int[] topKFrequent() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxHeap.add(entry);
        }

        int[] result = new int[k];
        int j=0;
        while(j<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            result[j] = entry.getKey();
            j++;
        }
        return result;
    }
}
