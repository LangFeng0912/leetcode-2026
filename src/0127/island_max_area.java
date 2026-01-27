class Solution {
    boolean[][] visited;
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        visited = new boolean[m][n];
        for(int x = 0; x<m; x++){
            for(int y = 0; y<n; y++){
                if(grid[x][y] == 1 && !visited[x][y]){
                    int area = dfs(grid, x, y);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;

    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if (grid[i][j] == 0){
            return 0;
        }
        if (visited[i][j]){
            return 0;
        }

        visited[i][j] = true;
        return dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1) + 1;
    }
}