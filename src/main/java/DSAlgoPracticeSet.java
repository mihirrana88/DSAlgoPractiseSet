import Consumer.MessageConsumer;
import DS.Arrays.NetTest;
import Producer.MessageProducer;

import java.lang.*;
import java.util.*;

public class DSAlgoPracticeSet {
    public static void main(String[] args) throws Exception {

        OutputDecorator.printDisplayHeading();
        Scanner scanner = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();
        List<String> emails = new ArrayList<>();

        emails.add("mihir@gmail.com");
        emails.add("pankaj@gmail.com");

        MessageProducer messageProducer = new MessageProducer();
        messageProducer.produceMessage(queue, "blue");
        messageProducer.produceMessage(queue, "red flag");
        messageProducer.produceMessage(queue, "green");
        messageProducer.produceMessage(queue, "red");

        MessageConsumer consumer = new MessageConsumer();

        while (!queue.isEmpty()) {
            consumer.consumeMessage(queue, emails);
        }

        //-----------------------------------------------------------

        // #Algorithms ==> Sorting
        //Problem.quickSort(scanner);
        //Problem.mergeSort(scanner);

        // #Arrays
        //Problem.maxSumSubArray(scanner);
        //Problem.majorityElementInArray(scanner);
        //Problem.stockBuyAndSellV1(scanner);
        //Problem.stockBuyAndSellV2(scanner);
        //Problem.rainWaterTrapping(scanner);
        //Problem.removeDuplicatesFromSortedArray(scanner);
        //Problem.twoSumArray(scanner);
        //Problem.moveZerosToEnd(scanner);
        //Problem.findPivotIndexFromArray(scanner);
        //Problem.findRunningSumOf1DArray(scanner);
        //Problem.findDuplicateNumberArray(scanner);
        //Problem.sortColorsArrays(scanner);
        //Problem.findContainerWithMaxWaterArray(scanner);
        //Problem.isReachableToEndOfArray(scanner);
        //Problem.jumpGameII(scanner);
        //Problem.jumpGameIII(scanner);
        //Problem.longestConsecutiveSequence(scanner);
        //Problem.maxFruitIntoBasket(scanner);
        //Problem.specialSequenceArray(scanner);

        // #Binary Search
        //Problem.searchInSortedRotatedArray(scanner);
        //Problem.findPeakElementFromArray(scanner);

        // #Bit Manipulation
        //Problem.findSingleNonRepeatedNumberFromArray(scanner);
        //Problem.findHammingWeightOfInputNumber(scanner);
        //Problem.findSumOfTwoIntegers(scanner);
        //Problem.findDivisionOfTwoIntegers(scanner);

        // #Dynamic Programming
        //Problem.coinChange(scanner);
        //Problem.generateParentheses(scanner);
        //Problem.decodeWays(scanner);

        // #HashMap
        //Problem.distinctCountInKSizeWindow(scanner);
        //Problem.topKFrequentElements(scanner);

        // #Maths
        //Problem.findPrimeCount(scanner);
        //Problem.findGreatestCommonDivisor(scanner);
        //Problem.findPowerOfThreeOfInputNumber(scanner);
        //Problem.isHappyNumberIsInputNumber(scanner);
        //Problem.calculateExpression(scanner);
        //Problem.findPerfectSquareInputNumber(scanner);
        //Problem.findPowerXIsToN(scanner);
        //Problem.findFactorialTrailingZeroes(scanner);

        // # Matrix
        //Problem.spiralMatrix(scanner);
        //Problem.spiralMatrixII(scanner);

        // Queue
        //Problem.maximumSumCircularSubarray(scanner);
        //Problem.removeDuplicateLetters(scanner);

        // Recursion
        //Problem.josephusProblem(scanner);
        //Problem.isPalindrome(scanner);
        //Problem.matrixPath(scanner);

        // #Stack
        //Problem.evaluateReversePolishNotation(scanner);
        //Problem.findLargestRectangleInHistogram(scanner);
        //Problem.decodeString(scanner);

        // #Strings
        //Problem.stringPatternMatch(scanner);
        //Problem.longestSubstringWithoutRepeatingCharacter(scanner);
        //Problem.allAnagramsFromString(scanner);
        //Problem.isValidParentheses(scanner);
        //Problem.findLongestCommonPrefix(scanner);
        //Problem.reverseString(scanner);
        //Problem.findLargestNumber(scanner);
        //Problem.minimumWindowSubstring(scanner);
        //Problem.stringToInteger(scanner);
        //Problem.longestValidParentheses(scanner);
        //Problem.longestHappyPrefix(scanner);

        // #Trees ==> BinaryTree
        //Problem.preOrderTraversalOfBinaryTree(scanner);
        //Problem.inOrderTraversalOfBinaryTree(scanner);
        //Problem.postOrderTraversalOfBinaryTree(scanner);
        //Problem.levelOrderTraversalOfBinaryTree(scanner);
        //Problem.leftViewOfBinaryTree(scanner);
        //Problem.rightViewOfBinaryTree(scanner);
        //Problem.topViewOfBinaryTree(scanner);
        //Problem.bottomViewOfBinaryTree(scanner);
    }
}
