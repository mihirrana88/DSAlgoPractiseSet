package DS.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    TreeNode root = null;

    public void createBinaryTree(Integer[] array) {
        if (array == null || array.length==0) {
            return;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 1; i < array.length; i++) {
            integerQueue.offer(array[i]);
        }

        TreeNode treeNode = new TreeNode(array[0]);
        treeNodeQueue.offer(treeNode);

        while (!integerQueue.isEmpty()){
            Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            TreeNode current = treeNodeQueue.poll();
            if (leftVal != null) {
                TreeNode left = new TreeNode(leftVal);
                current.left = left;
                treeNodeQueue.offer(left);
            }
            if (rightVal != null){
                TreeNode right = new TreeNode(rightVal);
                current.right = right;
                treeNodeQueue.offer(right);
            }
        }

        root = treeNode;
    }

    public int getHeight(TreeNode node){
        if(null == node){
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int getSize(TreeNode node){
        if(null == node){
            return 0;
        }

        return getSize(node.left) + getSize(node.right) + 1;
    }
}
