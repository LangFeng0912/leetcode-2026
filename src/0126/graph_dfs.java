import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static List<Integer> path = new ArrayList<>();
    public static boolean find = false;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        int m = sc.nextInt();
        int i = 0;

        while(i<m){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph[node1-1][node2-1] = 1;
            i++;
        }

        dfs(graph, 0);
        if(!find){
            System.out.print("-1");
        }
    }

    private static void dfs(int[][] graph, int node){
        if(path.contains(node)){
            return;
        }
        path.add(node);
        if(node == graph.length-1){
            find = true;
            for(int i = 0; i<path.size(); i++){
                if(i!=path.size()-1){
                    System.out.print(path.get(i)+1);
                    System.out.print(" ");
                }else{
                    System.out.println(path.get(i)+1);
                }
            }
            return;
        }

        ArrayList<Integer> nodes = new ArrayList<>();
        for( int i =0; i<graph.length; i++){
            if (graph[node][i] == 1){
                nodes.add(i);
            }
        }

        for(Integer nextNode: nodes){
            dfs(graph, nextNode);
            path.remove(nextNode);
        }

    }
}