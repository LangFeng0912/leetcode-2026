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
    HashSet<TreeNode> nodeSet;
    int maxLevel = 1;
    TreeNode ans;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        nodeSet = new HashSet<TreeNode>();
        nodeSet.add(root);
        dfs(root, 1);
        dfs1(root);
        return ans;
    }

    private void dfs(TreeNode node, int level){
        if(node == null) {
            return;
        }
        int culLevel = level;
        if (culLevel > maxLevel) {
            maxLevel = culLevel;
            nodeSet.clear();
            nodeSet.add(node);
        } else if (culLevel == maxLevel) {
            nodeSet.add(node);
        }

        
        dfs(node.left, culLevel+1);
        dfs(node.right, culLevel+1);
    }

    private int dfs1(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int match = 0;
        if (nodeSet.contains(node)) {
            match = 1;
        }

        int left = dfs1(node.left);
        int right = dfs1(node.right);
        int total = left + right + match;

        if (ans == null && total == nodeSet.size()) {
            ans = node;
        }

        return total;
    }
}