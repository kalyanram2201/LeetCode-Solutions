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
    public TreeNode deleteNode(TreeNode node, int key) {
        TreeNode temp;
        if(node==null){
            return node;
        }
        
        if(key<node.val){
            node.left=deleteNode(node.left,key);
        }
        else if(key>node.val){
           node.right= deleteNode(node.right,key);
        }
        else{
            if(node.left==null){
                return node.right;
            }
            if(node.right==null){
                return node.left;
            }
            temp=pred(node.left);
            node.val=temp.val;
            node.left=deleteNode(node.left,temp.val);
        }
        return node;
    
    }

    private TreeNode pred(TreeNode node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }
    
}