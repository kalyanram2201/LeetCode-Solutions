/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        root=insertNode(root,val);
        return root;
    }

    private TreeNode insertNode(TreeNode node,int val){
        if(node==null){
            return new TreeNode(val);
        }
        if(node.val<val){
            node.right=insertNode(node.right,val);
        }else{
            node.left=insertNode(node.left,val);
        }
        return node;
    }
}