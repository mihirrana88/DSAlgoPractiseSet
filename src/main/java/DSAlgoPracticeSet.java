import DS.Arrays.MajorityElementInArray;
import DS.Arrays.MaxSumSubArray;
import DS.Arrays.StockBuyAndSellV1;
import DS.Strings.StringPatternMatch;
import DS.Tree.BinaryTree.BinaryTree;
import DS.Tree.BinaryTree.InOrderTraversalBinaryTree;
import DS.Tree.BinaryTree.PostOrderTraversalBinaryTree;
import DS.Tree.BinaryTree.PreOrderTraversalBinaryTree;

import java.lang.*;
import java.util.*;

public class DSAlgoPracticeSet {
    public static void main(String[] args) throws Exception {
        OutputDecorator.printDisplayHeading();
        Scanner scanner = new Scanner(System.in);

        // #Arrays
        //maxSumSubArray(scanner);
        //majorityElementInArray(scanner);
        //stockBuyAndSellV1(scanner);

        // #Strings
        //stringPatternMatch(scanner);

        // #Trees ==> BinaryTree
        preOrderTraversalOfBinaryTree(scanner);
        inOrderTraversalOfBinaryTree(scanner);
        postOrderTraversalOfBinaryTree(scanner);
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
}
