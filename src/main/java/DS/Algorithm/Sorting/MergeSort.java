package DS.Algorithm.Sorting;

import Exception.InvalidInputArgument;

public class MergeSort {
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

    public int[] mergeSort() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int m = left + (right - left)/2;

            mergeSort(nums, left, m);
            mergeSort(nums, m+1, right);

            merge(nums, left, m, right);
        }
    }

    private void merge(int[] nums, int left, int m, int right){
        int n1 = m - left + 1;
        int n2 = right - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0; i<n1; ++i){
            L[i] = nums[left+i];
        }

        for (int j=0; j<n2; ++j){
            R[j] = nums[m+1+j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2){
            if(L[i] <= R[j]){
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2){
            nums[k] = R[j];
            j++;
            k++;
        }

    }

}
