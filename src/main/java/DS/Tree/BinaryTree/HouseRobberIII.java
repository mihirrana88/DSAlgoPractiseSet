package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

import java.util.HashMap;

/*
House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour,
the smart thief realized that all houses in this place form a binary tree. It will automatically
contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

Example 1:
Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 104

*/

public class HouseRobberIII {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public int rob(){
        return rob(binaryTreeInput.root);
    }

    public int rob(TreeNode root) {
        int ans[]=find(root);
        return Math.max(ans[0],ans[1]);
    }

    public int[] find(TreeNode root)
    {   if(root==null)
        return new int[]{0,0};
        int left[]=find(root.left);
        int right[]=find(root.right);
        int in=root.data+left[1]+right[1];
        int out=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{in,out};
    }

    HashMap<TreeNode,Integer> map=new HashMap();
    public int rob2(TreeNode root) {
        return find2(root);
    }
    public int find2(TreeNode root)
    {
        if(map.containsKey(root))
            return map.get(root);
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return root.data;
        int ll1=0,ll2=0,rr1=0,rr2=0;
        if(root.left!=null){
            ll1=find2(root.left.left);
            ll2=find2(root.left.right);
        }
        if(root.right!=null){
            rr2=find2(root.right.left);
            rr1=find2(root.right.right);
        }
        int sum=Math.max(find2(root.left)+find2(root.right),(ll1+rr2+ll2+rr1+root.data));
        map.put(root,sum);
        return sum;
    }
}
