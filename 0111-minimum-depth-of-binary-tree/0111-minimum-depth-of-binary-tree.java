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
    public int minDepth(TreeNode root) {
         return height(root);
    }
    int height(TreeNode node){
        if(node==null){
            return 0;
        }
        if(node.left==null){
            return height(node.right)+1;
        }
        if(node.right==null){
            return height(node.left)+1;
        }

        int left=height(node.left);
        int right=height(node.right);
        return Math.min(left,right)+1;
    }  
    
}