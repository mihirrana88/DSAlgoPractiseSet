import DS.Arrays.MajorityElementInArray;
import DS.Arrays.MaxSumSubArray;
import DS.Arrays.StockBuyAndSellV1;

import java.lang.*;
import java.util.*;

public class DSAlgoPracticeSet {
    public static void main(String[] args) throws Exception {
        OutputDecorator.printDisplayHeading();
        Scanner scanner = new Scanner(System.in);

        // #Arrays
        maxSumSubArray(scanner);
        majorityElementInArray(scanner);
        stockBuyAndSellV1(scanner);
    }

    public static void maxSumSubArray(Scanner scanner) throws Exception {
        System.out.println("Starting MaxSumSubArray Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
        maxSumSubArray.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            maxSumSubArray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : maxSumSubArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+maxSumSubArray.getMaxSumOfSubArrayV2());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void majorityElementInArray(Scanner scanner) throws Exception {
        System.out.println("Starting MajorityElementInArray Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        MajorityElementInArray majorityElementInArray = new MajorityElementInArray();
        majorityElementInArray.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            majorityElementInArray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : majorityElementInArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+majorityElementInArray.findMajorityElementFromGivenArray());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void stockBuyAndSellV1(Scanner scanner) throws Exception {
        System.out.println("Starting StockBuysAndSellV1 Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        StockBuyAndSellV1 stockBuyAndSellV1 = new StockBuyAndSellV1();
        stockBuyAndSellV1.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            stockBuyAndSellV1.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : stockBuyAndSellV1.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+stockBuyAndSellV1.getMaximumProfitPossible());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }
}
