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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(root,targetSum,list,result);
        return result;
    }
    void helper(TreeNode node,int sum,List<Integer> list,List<List<Integer>> result){
        if(node==null){
            return;
        }
        list.add(node.val);
        if(node.val==sum && node.left==null && node.right==null){
            result.add(new ArrayList<>(list));
        }
        else{
            helper(node.left,sum-node.val,list,result);
            helper(node.right,sum-node.val,list,result);
        }

        list.remove(list.size()-1);
    }

}