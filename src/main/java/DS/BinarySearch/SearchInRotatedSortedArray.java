package DS.BinarySearch;

import Exception.InvalidInputArgument;

public class SearchInRotatedSortedArray {
    public int[] nums = null;
    public Integer target = 0;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public void acceptTarget(Integer target) throws Exception {
        if(null == target){
            throw new InvalidInputArgument(target);
        }
        this.target = target;
    }

    public int searchTarget() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        int Lp = 0, Rp = nums.length - 1;

        while (Lp <= Rp) {
            int mid = (Lp + Rp) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[Lp] < nums[mid] && target < nums[mid] && target >= nums[Lp]) {
                Rp = mid - 1;
            }

            else if (nums[Rp] > nums[mid] && target > nums[mid] && target <= nums[Rp]) {
                Lp = mid + 1;
            }

            else {
                if (nums[mid] > nums[Rp])
                    Lp = mid + 1;
                else
                    Rp = mid - 1;
            }
        }
        return -1;
    }
}
