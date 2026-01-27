class Solution {
    int totalNumber = 0;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        for(int x=0; x<m; x++){
            for(int y = 0; y<n; y++){
                if(!visited[x][y] && grid[x][y] == '1' ){
                    dfs(grid, x,y);
                    totalNumber ++;
                }
            }
        }

        return totalNumber;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0){
            return;
        }
        if(visited[i][j]){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        
        visited[i][j] = true;
    
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

}