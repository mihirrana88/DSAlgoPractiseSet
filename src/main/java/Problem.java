import DS.Arrays.*;
import DS.HashMap.DistinctCountInKSizeWindow;
import DS.Strings.StringPatternMatch;
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
