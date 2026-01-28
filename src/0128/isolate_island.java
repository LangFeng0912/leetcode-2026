import java.util.Scanner;

public class Main {
    
    static int[][] graph;
    static boolean[][] visited;
    static boolean edge;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        int total = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                edge = false;
                int res = dfs(i, j);
                total = total + res;
            }
        }

        System.out.println(total);


    }

    private static int dfs(int i, int j){
        if(i<0 || i>=graph.length || j<0 || j>=graph[0].length){
            return 0;
        }

        if(visited[i][j]){
            return 0;
        }

        if(graph[i][j] == 0){
            return 0;
        }

        visited[i][j] = true;

        if(i == 0 || i == graph.length -1 
            || j == 0 || j == graph[0].length -1){
                edge = true;
            }

        int sumVal = dfs(i-1,j) 
            + dfs(i+1,j) 
            + dfs(i,j-1) 
            + dfs(i,j+1) + 1;
        
        if(!edge){
            return sumVal;
        }
        
        return 0;

    }
}