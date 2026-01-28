import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{

    static int[][] graph;
    static boolean[][] visited;
    static boolean edge;
    static List<int[]> islands = new ArrayList<>(); 

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n][m];
        int[][] res = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                int val = sc.nextInt(); 
                graph[i][j] = val;
                res[i][j] = val;      
            }
        }

        for(int x = 0; x<n; x++){
            for(int y = 0; y<m; y++){
                if(graph[x][y] == 1 && !visited[x][y]){
                    islands = new ArrayList<>(); 
                    edge = false;
                    dfs(x,y);
                    if(!edge){
                        for(int[] island:islands){
                            res[island[0]][island[1]] = 0;
                        }
                    }  
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if (j!= m-1){
                    System.out.print(res[i][j]);
                    System.out.print(" "); 
                } else {
                    System.out.println(res[i][j]);
                }
            }
        }



    }

    private static void dfs(int i, int j){
        if(i < 0 || i>= graph.length || j< 0 || j>=graph[0].length){
            return;
        }

        if(visited[i][j]){
            return;
        }

        if(graph[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        islands.add(new int[]{i,j});

        if(i == 0 || i== graph.length-1 || j== 0 || j==graph[0].length-1){
            edge = true;
        }

        dfs(i-1,j);
        dfs(i+1,j);
        dfs(i, j-1);
        dfs(i, j+1);
    }
}