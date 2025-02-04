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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helperview(root,0,list);
        return list;
    }
    private static void helperview(TreeNode temp,int level,List<Integer> list){
        if(temp==null){
            return;
        }
        if(level==list.size()){
            list.add(temp.val);
        }
        helperview(temp.right,level+1,list);
        helperview(temp.left,level+1,list);
    }
}