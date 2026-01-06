class Solution {

    int n;
    int res = 1;
    long maxProduct = 0L;

    static class TreeNode {
        TreeNode left;
        TreeNode right;

        void addChild(TreeNode child) {
            if (this.left == null) {
                this.left = child;
            } else {
                this.right = child;
            }
        }
    }

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        TreeNode[] nodes = new TreeNode[n];

        for(int i = 0; i<n; i++) {
            nodes[i] = new TreeNode();
        }

        for(int i = 1; i<n; i++) {
            nodes[parents[i]].addChild(nodes[i]);
        }

        dfs(nodes[0]);
        return res;
        
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int curNum = left + right + 1;
        int remain = n - left - right -1;
        long product = getFactor(left) * getFactor(right) * getFactor(remain);
        System.out.println(product);
        if (product > maxProduct) {
            maxProduct = product;
            res = 1;
        } else if (product == maxProduct) {
            res++;
        }

        return curNum;
    }

    private long getFactor(int num) {
        if (num == 0) {
            return 1;
        }
        return num;
    }
}