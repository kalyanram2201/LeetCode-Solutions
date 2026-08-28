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
    long max = 0;
    long total = 0;
    int mod = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum(root);
        dfs(root);
        return (int) (max % mod);
    }

    long totalSum(TreeNode node) {
        if (node == null)
            return 0;
        total += node.val;
        totalSum(node.left);
        totalSum(node.right);
        return total;
    }

    long dfs(TreeNode node) {
        if (node == null)
            return 0;

        long left = dfs(node.left);
        long right = dfs(node.right);

        long subSum = node.val + left + right;
        max = Math.max(max, subSum * (total - subSum));

        return subSum;
    }
}
