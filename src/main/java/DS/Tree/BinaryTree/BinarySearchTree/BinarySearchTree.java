package DS.Tree.BinaryTree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BSTNode root = null;

    public void createBinaryTree(Integer[] array) {
        if (array == null || array.length==0) {
            return;
        }

        Queue<BSTNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 1; i < array.length; i++) {
            integerQueue.offer(array[i]);
        }

        BSTNode treeNode = new BSTNode(array[0]);
        treeNodeQueue.offer(treeNode);

        while (!integerQueue.isEmpty()){
            Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            BSTNode current = treeNodeQueue.poll();
            if (leftVal != null) {
                BSTNode left = new BSTNode(leftVal);
                current.left = left;
                treeNodeQueue.offer(left);
            }
            if (rightVal != null){
                BSTNode right = new BSTNode(rightVal);
                current.right = right;
                treeNodeQueue.offer(right);
            }
        }

        root = treeNode;
    }

    public int getHeight(BSTNode node){
        if(null == node){
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int getSize(BSTNode node){
        if(null == node){
            return 0;
        }

        return getSize(node.left) + getSize(node.right) + 1;
    }
}
