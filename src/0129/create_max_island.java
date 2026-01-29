import java.util.Scanner;

public class Main{

    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(graph[i][j] == 1){
                    int curArea = dfs(i,j);
                    maxArea = Integer.max(maxArea, curArea);
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(graph[i][j] == 0){
                    graph[i][j] = 1;
                    visited = new boolean[n][m];
                    int curArea = dfs(i,j);
                    maxArea = Integer.max(maxArea, curArea);
                    graph[i][j] = 0;
                }
            }
        }

        System.out.println(maxArea);


    }

    private static int dfs(int i,int j){
        if(i<0 || j<0 || i>=graph.length || j>=graph[0].length){
            return 0;
        }

        if(graph[i][j] == 0){
            return 0;
        }

        if(visited[i][j]){
            return 0;
        }

        visited[i][j] = true;
        return dfs(i-1,j) + dfs(i, j-1) + dfs(i+1,j) + dfs(i,j+1) +1;
    }
}