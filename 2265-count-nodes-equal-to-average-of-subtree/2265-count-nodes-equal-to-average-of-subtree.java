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
    int cnt = 0;
    int ans = 0;
    public int sumNode(TreeNode root){

        if(root == null){
            return 0;
        } 

        int sum = 0;
        cnt++;

        int leftSum = sumNode(root.left);
        int rightSum = sumNode(root.right);

        return leftSum+rightSum+root.val;
    }
    public void preorder(TreeNode root){ 
        if(root == null){
            return ;
        }
        cnt = 0;

        int sum = sumNode(root);

        if(sum/cnt == root.val){
            ans++;
        }

        preorder(root.left);
        preorder(root.right);
    }
    
    public int averageOfSubtree(TreeNode root) {
        preorder(root);
        return ans;
    }
}