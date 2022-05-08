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

    public int[] mergeSort2() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }
        mergeSort2(nums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort2(int[] a, int l, int r){
        if(l < r){
            int mid = l + (r-l)/2;
            mergeSort2(a, l, mid);
            mergeSort2(a, mid+1, r);
            merge2(a, l, mid, r);
        }
    }

    public void merge2(int[] a, int l, int mid,  int r){
        int[] b = new int[a.length];
        int i = l;
        int j = mid + 1;
        int k = l;

        while (i <= mid && j <= r){
            if(a[i] < a[j]){
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        /*
        if(i<mid+1){
            while (i<=mid){
                b[k] = a[i];
                i++;
                k++;
            }
        } else {
            while (j<=r){
                b[k] = a[j];
                j++;
                k++;
            }
        }*/



        while (i<=mid){
            b[k] = a[i];
            i++;
            k++;
        }

        while (j<=r){
            b[k] = a[j];
            j++;
            k++;
        }

        for(k=l; k<=r; k++){
            a[k] = b[k];
        }
    }
}
