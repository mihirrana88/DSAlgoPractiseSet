package DS.Arrays;

import java.util.*;

public class JumpGameIV {
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

    /*

    Explanation:

        Step 1: if the length is less than or equal to 1, then we can return 1.

        Step 2: Create a IndexGrouper. For first example, below is the index grouped value.
        {3=[8], 100=[0, 4], 404=[3, 9], -23=[1, 2], 23=[5, 6, 7]}

        Step 3: Add initial object 0-indexed value to queue to kick start BFS.

        Step 4: Perform BFS. You will add to processing only if it is not visited already index is valid [0 - n]

        Step 5: clear the index grouper post single iteration, as it is not required to loop everytime
        when we encounter the same element.

     */
    public int minJumps() {
        int arrSize = nums.length;
        // Step 1
        if (arrSize <= 1) {
            return 0;
        }
        // Step 2
        Map<Integer, List<Integer>> indexGrouper = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arrSize; i++) {
            indexGrouper.putIfAbsent(nums[i], new ArrayList<Integer>());
            indexGrouper.get(nums[i]).add(i);
        }

        // Step 3
        Queue<Jump> q = new LinkedList<Jump>();
        q.add(new Jump(0, nums[0], 0));

        Set<Integer> visitedIndex = new HashSet<Integer>();
        visitedIndex.add(0);
        // Step 4
        while (q.isEmpty() == false) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Jump jump = q.remove();
                int index = jump.index;
                int value = jump.value;
                int step = jump.step;

                // breaking conditions
                if (index == arrSize-1) {
                    return step;
                }

                List<Integer> indexes = indexGrouper.get(value);
                indexes.add(index+1);
                indexes.add(index-1);

                for (int ind: indexes) {
                    if (ind >= 0 && ind < arrSize && visitedIndex.contains(ind) == false) {
                        q.add(new Jump(ind, nums[ind], step + 1));
                        visitedIndex.add(ind);
                    }
                }
                // Important: Step 5
                // Otherwise TLE
                indexes.clear();
            }
        }
        return -1;
    }

    class Jump {
        int index, value, step;

        Jump(int index, int value, int step) {
            this.index = index;
            this.value = value;
            this.step = step;
        }
    }
}
