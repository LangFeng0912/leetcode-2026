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

    List<Integer> levelSum = new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);

        int res = 0;
        int maxVal = levelSum.get(0);

        for (int i = 0; i<levelSum.size(); i++) {
            if (levelSum.get(i) > maxVal) {
                maxVal = levelSum.get(i);
                res = i;
            }
        }

        return res+1;
        
    }

    private void dfs(TreeNode node, int level) {
        if (level == levelSum.size()) {
            levelSum.add(node.val);
        } else {
            levelSum.set(level, levelSum.get(level) + node.val);
        }

        if (node.left != null) {
            dfs(node.left, level + 1);
        }

        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }
}