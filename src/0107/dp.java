class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int NEG = -1_000_000_000;  
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], NEG);
        }

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                int v = nums1[i] * nums2[j];

                int best = v;

                if (i>0 && j >0) {
                    best = Math.max(best, v + Math.max(0, dp[i-1][j-1]));
                }

                if (i>0) {
                    best = Math.max(best, dp[i-1][j]);
                }

                if (j>0) {
                    best = Math.max(best,dp[i][j-1]);
                }

                dp[i][j] = best;
            }
        }

        return dp[m-1][n-1];       
    }
}