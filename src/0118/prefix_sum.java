class Solution {
    int maxL = 0;
    public int maxSideLength(int[][] mat, int threshold) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] suffix = new int[row+1][col+1];

        for(int i = 1; i<=row; i++){
            for(int j =1; j<=col; j++){
                suffix[i][j] = mat[i-1][j-1] + suffix[i-1][j] + suffix[i][j-1] - suffix[i-1][j-1];
            }
        }

        for(int i = 1; i<=row; i++){
            for(int j = 1; j<=col; j++){
                int k = 0;
                while((i+k)<=row && (j+k)<=col){
                    int curSum = suffix[i+k][j+k] - suffix[i-1][j+k] - suffix[i+k][j-1] + suffix[i-1][j-1];
                    if (curSum <= threshold){
                        maxL = Math.max(k+1, maxL);
                    }
                    k++;
                }
            }
        }

        return maxL;

        
    }

    private boolean smallerThres(int[][] mat, int[] index, int k, int threshold){
        int sumQ = 0;
        for(int x = 0; x<=k; x++){
            for(int y = 0; y<=k; y++){
                sumQ += mat[index[0]+x][index[1]+y];
            }
        }
        return (sumQ<=threshold);
    }
}