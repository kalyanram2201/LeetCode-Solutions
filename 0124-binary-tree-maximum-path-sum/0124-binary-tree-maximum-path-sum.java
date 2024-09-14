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
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper2(root);
        return sum;
    }
    int helper2(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=helper2(node.left);
        int right=helper2(node.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        int psum=left+right+node.val;
        sum=Math.max(sum,psum);
        return Math.max(left,right)+node.val;
    }
}