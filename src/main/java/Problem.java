import DS.Arrays.*;
import DS.BinarySearch.FindPeakElement;
import DS.BinarySearch.SearchInRotatedSortedArray;
import DS.BitManipulation.DivideTwoIntegers;
import DS.BitManipulation.HammingWeight;
import DS.BitManipulation.SingleNumber;
import DS.BitManipulation.SumOfTwoInteger;
import DS.DynamicProgramming.CoinChange;
import DS.DynamicProgramming.DecodeWays;
import DS.DynamicProgramming.GenerateParentheses;
import DS.HashMap.DistinctCountInKSizeWindow;
import DS.HashMap.TopKFrequentElement;
import DS.Maths.*;
import DS.Queue.MaximumSumCircularSubarray;
import DS.Queue.RemoveDuplicateLetters;
import DS.Recursion.JosephusProblem;
import DS.Recursion.MatrixPath;
import DS.Recursion.PalindromeString;
import DS.Stack.DecodeString;
import DS.Stack.LargestRectangleHistogram;
import DS.Stack.ReversePolishNotation;
import DS.Strings.*;
import DS.Tree.BinaryTree.*;

import java.util.Scanner;

public class Problem {
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

    public static void stockBuyAndSellV2(Scanner scanner) throws Exception {
        System.out.println("Starting StockBuysAndSellV2 Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        StockBuyAndSellV2 stockBuyAndSellV2 = new StockBuyAndSellV2();
        stockBuyAndSellV2.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            stockBuyAndSellV2.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : stockBuyAndSellV2.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+stockBuyAndSellV2.getMaximumProfitPossible());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void moveZerosToEnd(Scanner scanner) throws Exception {
        System.out.println("Starting Move Zeros to end of Array Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            moveZeros.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : moveZeros.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        moveZeros.moveZerosToEnd();
        System.out.print("Output is:- ");
        for (int num : moveZeros.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void twoSumArray(Scanner scanner) throws Exception {
        System.out.println("Starting Two Sum Array Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();

        System.out.print("Provide target sum:- ");

        int targetSum = scanner.nextInt();

        TwoSumArray twoSumArray = new TwoSumArray();
        twoSumArray.getInputLength(inputLength);
        twoSumArray.getTargetSum(targetSum);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            twoSumArray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : twoSumArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        for (int num : twoSumArray.getTwoSumArray()){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void rainWaterTrapping(Scanner scanner) throws Exception {
        System.out.println("Starting Rainwater Trapping Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        RainwaterTrapping rainwaterTrapping = new RainwaterTrapping();
        rainwaterTrapping.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            rainwaterTrapping.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : rainwaterTrapping.heights){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+rainwaterTrapping.getMaximumWaterCanBeTrapped());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void removeDuplicatesFromSortedArray(Scanner scanner) throws Exception {
        System.out.println("Starting remove duplicates from sorted array Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        RemoveDuplicatesSortedArray removeDuplicatesSortedArray = new RemoveDuplicatesSortedArray();
        removeDuplicatesSortedArray.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            removeDuplicatesSortedArray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : removeDuplicatesSortedArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+removeDuplicatesSortedArray.removeDuplicatesFromSortedArray());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findPivotIndexFromArray(Scanner scanner) throws Exception {
        System.out.println("Starting Pivot Index from Array Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        PivotIndexArray pivotIndexArray = new PivotIndexArray();
        pivotIndexArray.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            pivotIndexArray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : pivotIndexArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+pivotIndexArray.getPivotIndex());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findRunningSumOf1DArray(Scanner scanner) throws Exception {
        System.out.println("Starting find running sum of 1D Array Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        RunningSum1DArray runningSum1DArray = new RunningSum1DArray();
        runningSum1DArray.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            runningSum1DArray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : runningSum1DArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        runningSum1DArray.getRunningSumOf1DArray();
        System.out.print("Output is:- ");
        for (int num : runningSum1DArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findDuplicateNumberArray(Scanner scanner) throws Exception {
        System.out.println("Starting Pivot Index from Array Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        DuplicateNumberArray duplicateNumberArray = new DuplicateNumberArray();
        duplicateNumberArray.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            duplicateNumberArray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : duplicateNumberArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+duplicateNumberArray.getDuplicateNumber());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void sortColorsArrays(Scanner scanner) throws Exception {
        System.out.println("Starting Sort Colors Array Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        SortColors sortColors = new SortColors();
        sortColors.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            sortColors.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : sortColors.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        sortColors.sortColors();
        System.out.print("Output is:- ");
        for (int num : sortColors.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void isReachableToEndOfArray(Scanner scanner) throws Exception {
        System.out.println("Starting Jump Game Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        JumpGame jumpGame = new JumpGame();
        jumpGame.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            jumpGame.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : jumpGame.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+jumpGame.isReachableToEnd());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void jumpGameII(Scanner scanner) throws Exception {
        System.out.println("Starting Jump Game II Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        JumpGameII jumpGameII = new JumpGameII();
        jumpGameII.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            jumpGameII.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : jumpGameII.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+jumpGameII.count());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void jumpGameIII(Scanner scanner) throws Exception {
        System.out.println("Starting Jump Game III Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();

        System.out.print("Provide start point:- ");

        int startPoint = scanner.nextInt();

        JumpGameIII jumpGameIII = new JumpGameIII();
        jumpGameIII.getInputLength(inputLength);
        jumpGameIII.getWindowSize(startPoint);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            jumpGameIII.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : jumpGameIII.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Given start point:- "+jumpGameIII.start);

        System.out.println();

        System.out.println("Output is:- "+jumpGameIII.canReach());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findContainerWithMaxWaterArray(Scanner scanner) throws Exception {
        System.out.println("Starting Container with max water Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        containerWithMostWater.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            containerWithMostWater.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : containerWithMostWater.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+containerWithMostWater.getContainerWithMaxWater());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findSingleNonRepeatedNumberFromArray(Scanner scanner) throws Exception {
        System.out.println("Starting find single non repeated number Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            singleNumber.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : singleNumber.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+singleNumber.getSingleNonRepeatedNumber());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findGreatestCommonDivisor(Scanner scanner) throws Exception {
        System.out.println("Starting Greatest Common Divisor Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        GreatestCommonDivisor greatestCommonDivisior = new GreatestCommonDivisor();
        greatestCommonDivisior.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            greatestCommonDivisior.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : greatestCommonDivisior.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+greatestCommonDivisior.greatestCommonDivisor());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findPowerOfThreeOfInputNumber(Scanner scanner) throws Exception {
        System.out.println("Starting Power Of Three of Number Problem...");
        System.out.print("Provide a input number:- ");

        int inputNumber = scanner.nextInt();
        PowerOfThree powerOfThree = new PowerOfThree();
        powerOfThree.acceptInput(inputNumber);

        System.out.println();

        System.out.print("Input is:- "+powerOfThree.n);

        System.out.println();

        System.out.println("Output is:- "+powerOfThree.isPowerOfThree());
        System.out.println("Output Time Complexity:- O(1)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void isHappyNumberIsInputNumber(Scanner scanner) throws Exception {
        System.out.println("Starting Happy Number Problem...");
        System.out.print("Provide a input number:- ");

        int inputNumber = scanner.nextInt();
        HappyNumber happyNumber = new HappyNumber();
        happyNumber.acceptInput(inputNumber);

        System.out.println();

        System.out.print("Input is:- "+happyNumber.n);

        System.out.println();

        System.out.println("Output is:- "+happyNumber.isHappyNumber());
        System.out.println("Output Time Complexity:- O(logn)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findFactorialTrailingZeroes(Scanner scanner) throws Exception {
        System.out.println("Starting Factorial Trailing Zeroes Problem...");
        System.out.print("Provide a input number:- ");

        int inputNumber = scanner.nextInt();
        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        factorialTrailingZeroes.acceptInput(inputNumber);

        System.out.println();

        System.out.print("Input is:- "+factorialTrailingZeroes.n);

        System.out.println();

        System.out.println("Output is:- "+factorialTrailingZeroes.getTrailingZeroes());
        System.out.println("Output Time Complexity:- O(logn)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findPerfectSquareInputNumber(Scanner scanner) throws Exception {
        System.out.println("Starting Perfect Square Problem...");
        System.out.print("Provide a input number:- ");

        int inputNumber = scanner.nextInt();
        PerfectSquares perfectSquares = new PerfectSquares();
        perfectSquares.acceptInput(inputNumber);

        System.out.println();

        System.out.print("Input is:- "+perfectSquares.n);

        System.out.println();

        System.out.println("Output is:- "+perfectSquares.perfectSquare());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void calculateExpression(Scanner scanner) throws Exception {
        System.out.println("Starting Calculator II Problem...");
        System.out.println();
        System.out.print("Provide a input expression as String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        BasicCalculatorII calculatorII = new BasicCalculatorII();
        calculatorII.acceptInputString(inputString);

        System.out.println();
        System.out.print("Input is:- "+calculatorII.inputString);
        System.out.println();

        System.out.println("Output:- "+calculatorII.evaluteExpression());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findHammingWeightOfInputNumber(Scanner scanner) throws Exception {
        System.out.println("Starting Hamming Weight of Number Problem...");
        System.out.print("Provide a input number:- ");

        int inputNumber = scanner.nextInt();
        HammingWeight hammingWeight = new HammingWeight();
        hammingWeight.acceptInput(inputNumber);

        System.out.println();

        System.out.print("Input is:- "+hammingWeight.n);

        System.out.println();

        System.out.println("Output is:- "+hammingWeight.getHammingWeight());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findSumOfTwoIntegers(Scanner scanner) throws Exception {
        System.out.println("Starting Sum of Two Integers Problem...");

        System.out.print("Provide a input number1:- ");
        int inputNumber1 = scanner.nextInt();

        System.out.println();

        System.out.print("Provide a input number2:- ");
        int inputNumber2 = scanner.nextInt();

        SumOfTwoInteger sumOfTwoInteger = new SumOfTwoInteger();
        sumOfTwoInteger.acceptInputNumber1(inputNumber1);
        sumOfTwoInteger.acceptInputNumber2(inputNumber2);

        System.out.println();

        System.out.print("Input numbers are:- "+sumOfTwoInteger.n1+", "+sumOfTwoInteger.n2);

        System.out.println();

        System.out.println("Output is:- "+sumOfTwoInteger.getSumOfTwoInteger());
        System.out.println("Output Time Complexity:- O(1)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findDivisionOfTwoIntegers(Scanner scanner) throws Exception {
        System.out.println("Starting Division of Two Integers Problem...");

        System.out.print("Provide a input dividend:- ");
        int inputNumber1 = scanner.nextInt();

        System.out.println();

        System.out.print("Provide a input divisor:- ");
        int inputNumber2 = scanner.nextInt();

        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        divideTwoIntegers.acceptInputNumber1(inputNumber1);
        divideTwoIntegers.acceptInputNumber2(inputNumber2);

        System.out.println();

        System.out.print("Input as follows, Dividend is "+divideTwoIntegers.n1+", Divisor is "+divideTwoIntegers.n2);

        System.out.println();

        System.out.println("Output is:- "+divideTwoIntegers.divisionOfTwoIntegers());
        System.out.println("Output Time Complexity:- O(logN)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findPowerXIsToN(Scanner scanner) throws Exception {
        System.out.println("Starting Pow(x, n) Problem...");

        System.out.print("Provide a input x:- ");
        double inputNumber1 = scanner.nextDouble();

        System.out.println();

        System.out.print("Provide a input n:- ");
        int inputNumber2 = scanner.nextInt();

        PowerXIsToN powerXIsToN = new PowerXIsToN();
        powerXIsToN.acceptInputNumber1(inputNumber1);
        powerXIsToN.acceptInputNumber2(inputNumber2);

        System.out.println();

        System.out.print("Input as follows, X is "+powerXIsToN.x+", N is "+powerXIsToN.n);

        System.out.println();

        System.out.println("Output is:- "+powerXIsToN.powerXisToN());
        System.out.println("Output Time Complexity:- O(logN)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void evaluateReversePolishNotation(Scanner scanner) throws Exception {
        System.out.println("Starting Evaluate Reverse Polish Notation Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.acceptInput(inputString);

        System.out.println();
        System.out.println("input length ==>"+reversePolishNotation.inputString.length);
        System.out.print("Input:- ");
        for (String s : reversePolishNotation.inputString){
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("Output:- "+reversePolishNotation.evaluateReversePolishNotation());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void findLargestRectangleInHistogram(Scanner scanner) throws Exception {
        System.out.println("Starting Largest Rectangle In Histogram Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        largestRectangleHistogram.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            largestRectangleHistogram.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : largestRectangleHistogram.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+largestRectangleHistogram.getLargestRectangleInHistogram());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void josephusProblem(Scanner scanner) throws Exception {
        System.out.println("Starting Josephus Problem...");

        System.out.print("Provide a input n:- ");
        int n = scanner.nextInt();

        System.out.println();

        System.out.print("Provide a input k:- ");
        int k = scanner.nextInt();

        JosephusProblem josephusProblem = new JosephusProblem();
        josephusProblem.acceptInputN(n);
        josephusProblem.acceptInputK(k);

        System.out.println();

        System.out.print("Input as follows, n is "+josephusProblem.n+", k is "+josephusProblem.k);

        System.out.println();

        System.out.println("Output is:- "+josephusProblem.findWinner());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void matrixPath(Scanner scanner) throws Exception {
        System.out.println("Starting MatrixPath Problem...");

        System.out.print("Provide a input n:- ");
        int n = scanner.nextInt();

        System.out.println();

        System.out.print("Provide a input m:- ");
        int m = scanner.nextInt();

        MatrixPath matrixPath = new MatrixPath();
        matrixPath.acceptInputN(n);
        matrixPath.acceptInputM(m);

        System.out.println();

        System.out.print("Input as follows, n is "+matrixPath.n+", k is "+matrixPath.m);

        System.out.println();

        System.out.println("Output is:- "+matrixPath.findNumberOfWay());
        System.out.println("Output Time Complexity:- O(N*M)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void isPalindrome(Scanner scanner) throws Exception {
        System.out.println("Starting Palindrome String Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        PalindromeString palindromeString = new PalindromeString();
        palindromeString.acceptInputString(inputString);

        System.out.println();
        System.out.println();

        System.out.println("Output:Length of Longest Substring:- "+palindromeString.isPalindrome());
        System.out.println("Output Time Complexity:- O(N/2)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void decodeString(Scanner scanner) throws Exception {
        System.out.println("Starting Decode String Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        DecodeString decodeString = new DecodeString();
        decodeString.acceptInputString(inputString);

        System.out.println();
        System.out.println();

        System.out.println("Output:- "+decodeString.decodeString());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void distinctCountInKSizeWindow(Scanner scanner) throws Exception {
        System.out.println("Starting Distinct Element Count in K size window Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();

        System.out.print("Provide length of window k:- ");

        int windowSize = scanner.nextInt();

        DistinctCountInKSizeWindow distinctCountInKSizeWindow = new DistinctCountInKSizeWindow();
        distinctCountInKSizeWindow.getInputLength(inputLength);
        distinctCountInKSizeWindow.getWindowSize(windowSize);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            distinctCountInKSizeWindow.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : distinctCountInKSizeWindow.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Given size of window is k:- "+windowSize);

        System.out.println();

        System.out.print("Output is:- ");
        distinctCountInKSizeWindow.getDistinctCountInKSizeWindow();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void topKFrequentElements(Scanner scanner) throws Exception {
        System.out.println("Starting Top K Frequent Elements Problem...");

        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();

        System.out.print("Provide input k:- ");
        int kSize = scanner.nextInt();
        topKFrequentElement.getWindowSize(kSize);

        System.out.print("Provide length of input:- ");
        int inputLength = scanner.nextInt();
        topKFrequentElement.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            topKFrequentElement.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : topKFrequentElement.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Given size of k:- "+kSize);

        System.out.println();

        System.out.print("Output is:- ");
        for (int num : topKFrequentElement.topKFrequent()){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output Time Complexity:- O(N^2)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void stringPatternMatch(Scanner scanner) throws Exception {
        System.out.println("Starting StringPatternMatch Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();
        System.out.print("Provide a pattern to be matched:- ");
        String patternToBeMatched = scanner.nextLine();

        StringPatternMatch stringPatternMatch = new StringPatternMatch();
        stringPatternMatch.acceptInputString(inputString);
        stringPatternMatch.acceptInputPattern(patternToBeMatched);
        int patternMatchedFromIndex = stringPatternMatch.matchPatternIntoString();

        System.out.println();

        System.out.print("==> ");
        for (char ch : inputString.toCharArray()){
            System.out.print(ch+" ");
        }
        System.out.println();
        System.out.print("==> ");
        for (int i=0; i<inputString.length(); i++){
            if(patternMatchedFromIndex != -1
                    && i >= patternMatchedFromIndex
                    && i < patternToBeMatched.length()+patternMatchedFromIndex){
                System.out.print("^ ");
            }else {
                System.out.print("__");
            }
        }

        System.out.println();
        System.out.println();

        if (patternMatchedFromIndex == -1){
            System.out.println("Output:- pattern "+patternToBeMatched
                    +" doesn't matched in string "+inputString);
        }else{
            System.out.println("Output:- pattern "+patternToBeMatched
                    +" matched in string "+inputString
                    +" index starting from "+patternMatchedFromIndex
                    +" to "+(patternToBeMatched.length()+patternMatchedFromIndex));
        }
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void allAnagramsFromString(Scanner scanner) throws Exception {
        System.out.println("Starting Find All Anagrams from String Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();
        System.out.print("Provide a string to be anagram with:- ");
        String anagramWith = scanner.nextLine();

        AllAnagramsInString allAnagramsInString = new AllAnagramsInString();
        allAnagramsInString.acceptInputString(inputString);
        allAnagramsInString.acceptInputAnagramWith(anagramWith);

        System.out.println();

        System.out.print("Output:- ");
        for (int startIndex : allAnagramsInString.getAllAnagramsInString()){
            System.out.print(startIndex+" ");
        }

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void minimumWindowSubstring(Scanner scanner) throws Exception {
        System.out.println("Starting Minimum Window Substring Problem...");
        System.out.println();
        System.out.print("Provide a input String1:- ");
        String string1 = scanner.nextLine();
        System.out.println();
        System.out.print("Provide a input String2:- ");
        String string2 = scanner.nextLine();

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        minimumWindowSubstring.acceptInputString1(string1);
        minimumWindowSubstring.acceptInputString2(string2);

        System.out.println();

        System.out.println("Output is:- "+minimumWindowSubstring.minWindow());
        System.out.println("Output Time Complexity:- O(|S|+|T|)");
        System.out.println("Output Space Complexity:- O(|S|+|T|)");
    }

    public static void longestSubstringWithoutRepeatingCharacter(Scanner scanner) throws Exception {
        System.out.println("Starting Longest Substring Without Repeating Character Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        LongestSubstring longestSubstring = new LongestSubstring();
        longestSubstring.acceptInputString(inputString);

        System.out.println();
        System.out.println();

        System.out.println("Output:Length of Longest Substring:- "+longestSubstring
                .getLongestSubstringWithoutRepeatingCharacter());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void isValidParentheses(Scanner scanner) throws Exception {
        System.out.println("Starting Valid Parentheses Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.acceptInputString(inputString);

        System.out.println();
        System.out.println();

        System.out.println("Output:- "+validParentheses.checkIfValidParentheses());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void reverseString(Scanner scanner) throws Exception {
        System.out.println("Starting Reverse String Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        ReverseString reverseString = new ReverseString();
        reverseString.acceptInputString(inputString);

        System.out.println();
        System.out.println();

        reverseString.reverseString();
        System.out.println("Output:- "+reverseString.inputString);
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findPrimeCount(Scanner scanner) throws Exception {
        System.out.println("Starting Sieve of Eratosthenes Problem...");
        System.out.println();
        System.out.print("Provide a input Number:- ");
        Integer inputNumber = scanner.nextInt();
        System.out.println();

        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        sieveOfEratosthenes.acceptInputString(inputNumber);

        System.out.println();
        System.out.println();

        System.out.println("Output:- "+sieveOfEratosthenes.getPrimeCount());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void findLongestCommonPrefix(Scanner scanner) throws Exception {
        System.out.println("Starting find longest common prefix Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        longestCommonPrefix.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            String str = scanner.next();
            longestCommonPrefix.acceptInput(str, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (String str : longestCommonPrefix.strings){
            System.out.print(str+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+longestCommonPrefix.longestCommonPrefix());
        System.out.println("Output Time Complexity:- O(NM)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findLargestNumber(Scanner scanner) throws Exception {
        System.out.println("Starting Largest Number Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        LargestNumber largestNumber = new LargestNumber();
        largestNumber.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            largestNumber.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : largestNumber.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+largestNumber.largestNumber());
        System.out.println("Output Time Complexity:- O(NlogN)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void stringToInteger(Scanner scanner) throws Exception {
        System.out.println("Starting String to Integer (atoi) Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        StringToInteger stringToInteger = new StringToInteger();
        stringToInteger.acceptInputString(inputString);

        System.out.println();
        System.out.println();

        System.out.println("Output:Length of Longest Substring:- "+stringToInteger.atoi());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void searchInSortedRotatedArray(Scanner scanner) throws Exception {
        System.out.println("Starting Search in Rotated Sorted Problem...");

        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

        System.out.print("Provide input target:- ");
        Integer target = scanner.nextInt();
        searchInRotatedSortedArray.acceptTarget(target);

        System.out.println();

        System.out.print("Provide length of input:- ");
        int inputLength = scanner.nextInt();
        searchInRotatedSortedArray.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            searchInRotatedSortedArray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : searchInRotatedSortedArray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Input target is:- "+searchInRotatedSortedArray.target);

        System.out.println();

        System.out.println("Output is:- "+searchInRotatedSortedArray.searchTarget());
        System.out.println("Output Time Complexity:- O(logN)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void findPeakElementFromArray(Scanner scanner) throws Exception {
        System.out.println("Starting Find Peak Element of Array Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        FindPeakElement peakElement = new FindPeakElement();
        peakElement.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            peakElement.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : peakElement.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+peakElement.getPeakElement());
        System.out.println("Output Time Complexity:- O(NlogN)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void coinChange(Scanner scanner) throws Exception {
        System.out.println("Starting Coin Change Problem...");

        CoinChange coinChange = new CoinChange();

        System.out.print("Provide input amount:- ");
        Integer amount = scanner.nextInt();
        coinChange.acceptTarget(amount);

        System.out.println();

        System.out.print("Provide length of input:- ");
        int inputLength = scanner.nextInt();
        coinChange.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            coinChange.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : coinChange.coins){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Input amount is:- "+coinChange.amount);

        System.out.println();

        System.out.println("Output is:- "+coinChange.coinChange());
        System.out.println("Output Time Complexity:- O(MN)");
        System.out.println("Output Space Complexity:- O(M)");
    }

    public static void generateParentheses(Scanner scanner) throws Exception {
        System.out.println("Starting Generate Parentheses Problem...");
        System.out.print("Provide a input number:- ");

        int inputNumber = scanner.nextInt();
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.acceptInput(inputNumber);

        System.out.println();

        System.out.print("Input is:- "+generateParentheses.n);

        System.out.println();

        System.out.print("Output is:- ");
        for (String s : generateParentheses.generateParenthesis()){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.println("Output Time Complexity:- O(4^n/n^1/2)");
        System.out.println("Output Space Complexity:- O(4^n/n^1/2)");
    }

    public static void decodeWays(Scanner scanner) throws Exception {
        System.out.println("Starting Decode Ways Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        DecodeWays decodeWays = new DecodeWays();
        decodeWays.acceptInputString(inputString);

        System.out.println();

        System.out.println("Output:- "+decodeWays.getDecodeWaysCount());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void maximumSumCircularSubarray(Scanner scanner) throws Exception {
        System.out.println("Starting Maximum Sum Circular Subarray Problem...");
        System.out.print("Provide length of input:- ");

        int inputLength = scanner.nextInt();
        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
        maximumSumCircularSubarray.getInputLength(inputLength);

        System.out.print("Provide an input array:- ");
        for(int i=0; i<inputLength; i++){
            int num = scanner.nextInt();
            maximumSumCircularSubarray.acceptInput(num, i);
        }

        System.out.println();

        System.out.print("Input is:- ");
        for (int num : maximumSumCircularSubarray.nums){
            System.out.print(num+" ");
        }

        System.out.println();

        System.out.println("Output is:- "+maximumSumCircularSubarray.maxSubarraySumCircular());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(1)");
    }

    public static void removeDuplicateLetters(Scanner scanner) throws Exception {
        System.out.println("Starting Remove Duplicate Letters Problem...");
        System.out.println();
        System.out.print("Provide a input String:- ");
        String inputString = scanner.nextLine();
        System.out.println();

        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        removeDuplicateLetters.acceptInputString(inputString);

        System.out.println();
        System.out.println();

        System.out.println("Output:- "+removeDuplicateLetters.removeDuplicateLetters());
        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void preOrderTraversalOfBinaryTree(Scanner scanner) throws Exception {
        System.out.println("Starting Preorder traversal in BinaryTree Problem...");
        System.out.println();
        System.out.print("Provide an input array representation of BinaryTree:- ");

        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split("\\s+");
        Integer[] arrayRepresentationOfBinaryTree = new Integer[inputArray.length];
        int i = 0;

        for(String input : inputArray){
            if(input.equalsIgnoreCase("null")){
                arrayRepresentationOfBinaryTree[i] = null;
            }else {
                arrayRepresentationOfBinaryTree[i] = Integer.valueOf(input);
            }
            i++;
        }

        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.createBinaryTree(arrayRepresentationOfBinaryTree);

        PreOrderTraversalBinaryTree preOrderTraversalBinaryTree = new PreOrderTraversalBinaryTree();
        preOrderTraversalBinaryTree.acceptBinaryTreeInput(inputBinaryTree);

        System.out.println();

        System.out.print("Input is:- ");
        for (String s : inputArray){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        preOrderTraversalBinaryTree.preOrderTraversalInBinaryTree();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(H)");
    }

    public static void inOrderTraversalOfBinaryTree(Scanner scanner) throws Exception {
        System.out.println("Starting Preorder traversal in BinaryTree Problem...");
        System.out.println();
        System.out.print("Provide an input array representation of BinaryTree:- ");

        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split("\\s+");
        Integer[] arrayRepresentationOfBinaryTree = new Integer[inputArray.length];
        int i = 0;

        for(String input : inputArray){
            if(input.equalsIgnoreCase("null")){
                arrayRepresentationOfBinaryTree[i] = null;
            }else {
                arrayRepresentationOfBinaryTree[i] = Integer.valueOf(input);
            }
            i++;
        }

        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.createBinaryTree(arrayRepresentationOfBinaryTree);

        InOrderTraversalBinaryTree inOrderTraversalBinaryTree = new InOrderTraversalBinaryTree();
        inOrderTraversalBinaryTree.acceptBinaryTreeInput(inputBinaryTree);

        System.out.println();

        System.out.print("Input is:- ");
        for (String s : inputArray){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        inOrderTraversalBinaryTree.inOrderTraversalInBinaryTree();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(H)");
    }

    public static void postOrderTraversalOfBinaryTree(Scanner scanner) throws Exception {
        System.out.println("Starting Preorder traversal in BinaryTree Problem...");
        System.out.println();
        System.out.print("Provide an input array representation of BinaryTree:- ");

        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split("\\s+");
        Integer[] arrayRepresentationOfBinaryTree = new Integer[inputArray.length];
        int i = 0;

        for(String input : inputArray){
            if(input.equalsIgnoreCase("null")){
                arrayRepresentationOfBinaryTree[i] = null;
            }else {
                arrayRepresentationOfBinaryTree[i] = Integer.valueOf(input);
            }
            i++;
        }

        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.createBinaryTree(arrayRepresentationOfBinaryTree);

        PostOrderTraversalBinaryTree postOrderTraversalBinaryTree = new PostOrderTraversalBinaryTree();
        postOrderTraversalBinaryTree.acceptBinaryTreeInput(inputBinaryTree);

        System.out.println();

        System.out.print("Input is:- ");
        for (String s : inputArray){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        postOrderTraversalBinaryTree.postOrderTraversalInBinaryTree();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(H)");
    }

    public static void levelOrderTraversalOfBinaryTree(Scanner scanner) throws Exception {
        System.out.println("Starting level order traversal in BinaryTree Problem...");
        System.out.println();
        System.out.print("Provide an input array representation of BinaryTree:- ");

        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split("\\s+");
        Integer[] arrayRepresentationOfBinaryTree = new Integer[inputArray.length];
        int i = 0;

        for(String input : inputArray){
            if(input.equalsIgnoreCase("null")){
                arrayRepresentationOfBinaryTree[i] = null;
            }else {
                arrayRepresentationOfBinaryTree[i] = Integer.valueOf(input);
            }
            i++;
        }

        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.createBinaryTree(arrayRepresentationOfBinaryTree);

        LevelOrderTraversalBinaryTree levelOrderTraversalBinaryTree = new LevelOrderTraversalBinaryTree();
        levelOrderTraversalBinaryTree.acceptBinaryTreeInput(inputBinaryTree);

        System.out.println();

        System.out.print("Input is:- ");
        for (String s : inputArray){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        levelOrderTraversalBinaryTree.levelOrderTraversalInBinaryTree();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void leftViewOfBinaryTree(Scanner scanner) throws Exception {
        System.out.println("Starting left view of BinaryTree Problem...");
        System.out.println();
        System.out.print("Provide an input array representation of BinaryTree:- ");

        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split("\\s+");
        Integer[] arrayRepresentationOfBinaryTree = new Integer[inputArray.length];
        int i = 0;

        for(String input : inputArray){
            if(input.equalsIgnoreCase("null")){
                arrayRepresentationOfBinaryTree[i] = null;
            }else {
                arrayRepresentationOfBinaryTree[i] = Integer.valueOf(input);
            }
            i++;
        }

        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.createBinaryTree(arrayRepresentationOfBinaryTree);

        LeftViewBinaryTree leftViewBinaryTree = new LeftViewBinaryTree();
        leftViewBinaryTree.acceptBinaryTreeInput(inputBinaryTree);

        System.out.println();

        System.out.print("Input is:- ");
        for (String s : inputArray){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        leftViewBinaryTree.leftViewInBinaryTree();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void rightViewOfBinaryTree(Scanner scanner) throws Exception {
        System.out.println("Starting right view of BinaryTree Problem...");
        System.out.println();
        System.out.print("Provide an input array representation of BinaryTree:- ");

        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split("\\s+");
        Integer[] arrayRepresentationOfBinaryTree = new Integer[inputArray.length];
        int i = 0;

        for(String input : inputArray){
            if(input.equalsIgnoreCase("null")){
                arrayRepresentationOfBinaryTree[i] = null;
            }else {
                arrayRepresentationOfBinaryTree[i] = Integer.valueOf(input);
            }
            i++;
        }

        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.createBinaryTree(arrayRepresentationOfBinaryTree);

        RightViewBinaryTree rightViewBinaryTree = new RightViewBinaryTree();
        rightViewBinaryTree.acceptBinaryTreeInput(inputBinaryTree);

        System.out.println();

        System.out.print("Input is:- ");
        for (String s : inputArray){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        rightViewBinaryTree.rightViewInBinaryTree();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void topViewOfBinaryTree(Scanner scanner) throws Exception {
        System.out.println("Starting top view of BinaryTree Problem...");
        System.out.println();
        System.out.print("Provide an input array representation of BinaryTree:- ");

        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split("\\s+");
        Integer[] arrayRepresentationOfBinaryTree = new Integer[inputArray.length];
        int i = 0;

        for(String input : inputArray){
            if(input.equalsIgnoreCase("null")){
                arrayRepresentationOfBinaryTree[i] = null;
            }else {
                arrayRepresentationOfBinaryTree[i] = Integer.valueOf(input);
            }
            i++;
        }

        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.createBinaryTree(arrayRepresentationOfBinaryTree);

        TopViewBinaryTree topViewBinaryTree = new TopViewBinaryTree();
        topViewBinaryTree.acceptBinaryTreeInput(inputBinaryTree);

        System.out.println();

        System.out.print("Input is:- ");
        for (String s : inputArray){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        topViewBinaryTree.topViewInBinaryTree();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }

    public static void bottomViewOfBinaryTree(Scanner scanner) throws Exception {
        System.out.println("Starting bottom view of BinaryTree Problem...");
        System.out.println();
        System.out.print("Provide an input array representation of BinaryTree:- ");

        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split("\\s+");
        Integer[] arrayRepresentationOfBinaryTree = new Integer[inputArray.length];
        int i = 0;

        for(String input : inputArray){
            if(input.equalsIgnoreCase("null")){
                arrayRepresentationOfBinaryTree[i] = null;
            }else {
                arrayRepresentationOfBinaryTree[i] = Integer.valueOf(input);
            }
            i++;
        }

        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.createBinaryTree(arrayRepresentationOfBinaryTree);

        BottomViewBinaryTree bottomViewBinaryTree = new BottomViewBinaryTree();
        bottomViewBinaryTree.acceptBinaryTreeInput(inputBinaryTree);

        System.out.println();

        System.out.print("Input is:- ");
        for (String s : inputArray){
            System.out.print(s+" ");
        }

        System.out.println();

        System.out.print("Output is:- ");
        bottomViewBinaryTree.bottomViewInBinaryTree();

        System.out.println();

        System.out.println("Output Time Complexity:- O(N)");
        System.out.println("Output Space Complexity:- O(N)");
    }
}
