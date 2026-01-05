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
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int maxLevelSum = Integer.MIN_VALUE;
        int curLevel = 0;
        int res = 1;
    
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;
            
            for (int i = 0; i< size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    levelSum += current.val;
                }
            
                if(current.left != null){
                    queue.offer(current.left);
                }

                if(current.right != null){
                    queue.offer(current.right);
                }

            }
            curLevel ++;
            System.out.println(curLevel);
            System.out.println(levelSum);
            if(levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                res = curLevel;
            }
        }

        return res;
        
    }
}