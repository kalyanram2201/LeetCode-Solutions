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

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(0));
            return list;
        }

        if (map.containsKey(n))
            return map.get(n);

        List<TreeNode> result = new ArrayList<>();

        for (int left = 0; left < n; left++) {
            int right = n - 1 - left;

            List<TreeNode> lnodes = allPossibleFBT(left);
            List<TreeNode> rnodes = allPossibleFBT(right);

            for (TreeNode lnode : lnodes) {
                for (TreeNode rnode : rnodes) {

                    TreeNode root = new TreeNode(0, lnode, rnode);
                    result.add(root);
                }
            }
        }
        
        map.put(n, result);
        return result;
    }
}