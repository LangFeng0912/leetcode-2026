import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main{

    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0; i<n; i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        for(int i = 0; i<k; i++){
            int cur1 = sc.nextInt();
            int cur2 = sc.nextInt();
            adj.get(cur1-1).add(cur2);
            
        }

        visited= new boolean[n];

        dfs(1);

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                System.out.println("-1");
                return;
            }
        }

        System.out.println("1");
    }

    private static void dfs(int node){
        if(visited[node-1]){
            return;
        }

        visited[node-1] = true;

        for(Integer nextNode: adj.get(node-1)){
            dfs(nextNode);
        }

    }
}