import java.util.Scanner;
import java.lang.Integer;


public class Main{

    static int[][] graph;
    static boolean[][] visited;
    static boolean reach1 = false;
    static boolean reach2 = false;

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        for(int x = 0; x<n; x++){
            for(int y = 0; y<m; y++){
                visited = new boolean[n][m];
                reach1 = false;
                reach2 = false;
                dfs(x,y,Integer.MAX_VALUE);
                if(reach1 && reach2){
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                }
            }
        }


    }

    private static void dfs(int i,int j, int pre){
        if(i<0 || j<0 || i>=graph.length || j>=graph[0].length){
            return;
        }

        if(visited[i][j]){
            return;
        }

        if(graph[i][j]>pre){
            return;
        }

        visited[i][j] = true;

        if((i==0 || j==0)){
            reach1 = true;
        }

        if((i==graph.length-1 || j==graph[0].length-1)){
            reach2 = true;
        }

        dfs(i-1,j,graph[i][j]);
        dfs(i,j-1,graph[i][j]);
        dfs(i+1,j,graph[i][j]);
        dfs(i,j+1,graph[i][j]);
    }
}