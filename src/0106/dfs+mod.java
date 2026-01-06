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
    static final int MOD = 1_000_000_007;
    long maxValue = 0;
    int sumNodes;

    public int maxProduct(TreeNode root) {
        dfs_sum(root);
        dfs(root);
        return (int)(maxValue%MOD);
        
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
    
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        int total = node.val + leftSum + rightSum;
        long curProduct = 1L*total*(sumNodes-total);
        if (curProduct > maxValue) {
                maxValue = curProduct;
        }
        return total;
    }

    private void dfs_sum(TreeNode node) {
        if (node == null) {
            return ;
        }

        dfs_sum(node.left);
        dfs_sum(node.right);

        sumNodes += node.val;
    }
}