package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

*/

public class AverageOfLevelsInBinaryTree {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public List<Double> averageOfLevels() {

        List<Double> ans = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(binaryTreeInput.root);
        queue.add(list);

        while(!queue.isEmpty()){
            List<TreeNode> levelNodes = queue.poll();
            List<TreeNode> newLevelNodes = new ArrayList<>();
            Double sum = 0.0;
            for(int i=0; i<levelNodes.size(); i++){
                TreeNode node = levelNodes.get(i);
                sum += node.data;
                if(null != node.left){
                    newLevelNodes.add(node.left);
                }
                if(null != node.right){
                    newLevelNodes.add(node.right);
                }
            }
            ans.add(sum/levelNodes.size());
            if(newLevelNodes.size()>0){
                queue.add(newLevelNodes);
            }
        }

        return ans;
    }
}
