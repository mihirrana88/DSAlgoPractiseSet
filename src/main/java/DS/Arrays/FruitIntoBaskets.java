package DS.Arrays;

import Exception.InvalidInputArgument;

public class FruitIntoBaskets {
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

    public int totalFruit() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        if(nums.length==1) return 1;

        int max = 2;

        int sames = 0;

        int clusters[] = new int[2];
        int leftClusterCounter = 0;
        int rightClusterCounter = 0;

        int leftType  =nums[nums.length-2];
        int rightType =nums[nums.length-1];

        if(leftType!=rightType){
            clusters[0]=leftType;
            clusters[1]=rightType;
            leftClusterCounter  = 1;
            rightClusterCounter = 1;
            sames = 1;
        }else{
            clusters[0]=leftType;
            clusters[1]=Integer.MIN_VALUE;
            leftClusterCounter  = 2;
            rightClusterCounter = 0;
            sames = 2;
        }

        if(nums.length > 2){

            for(int i=nums.length-3; i>=0; i--){

                int currentType = nums[i];

                if (currentType==clusters[0]){
                    leftClusterCounter++;
                    sames++;
                }else if(currentType==clusters[1]){
                    int temp = leftClusterCounter;
                    leftClusterCounter = rightClusterCounter+1;
                    rightClusterCounter = temp;
                    clusters[1] = clusters[0];
                    clusters[0] = currentType;
                    sames=1;
                }else{
                    leftClusterCounter = 1;
                    rightClusterCounter = sames;
                    sames=1;
                    clusters[1] = clusters[0];
                    clusters[0] = currentType;
                }
                max = Math.max(max, rightClusterCounter+leftClusterCounter);

            }

        }

        return max;
    }
}
