package DS.Algorithm.Sorting;

import Exception.InvalidInputArgument;

public class QuickSort {
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

    public int[] quickSort() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right){
            int pivot = partition(nums, left, right);

            quickSort(nums, left, pivot-1);
            quickSort(nums, pivot+1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left-1;
        for(int j = left; j<right; j++){
            if(nums[j]<=pivot){
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
