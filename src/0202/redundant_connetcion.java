class Solution {
    int[] father;
    public int[] findRedundantConnection(int[][] edges) {
        int n = 1;
        for(int i = 0; i<edges.length; i++){
            n = Math.max(n, edges[i][0]);
            n = Math.max(n, edges[i][1]);
        }
        
        father = new int[n];
        for(int i = 0; i<n; i++){
            father[i] = i;
        }

        for(int i = 0; i<edges.length; i++){
            if(connected(edges[i][0]-1, edges[i][1]-1)){
                return edges[i];
            }
            join(edges[i][0]-1, edges[i][1]-1);
        }

        return null;
    }

    public int find(int u){
        if(father[u] == u){
            return u;
        }
        father[u] = find(father[u]);
        return father[u];
    }

    public boolean connected(int u, int v){
        return find(u) == find(v);
    }

    public void join(int u, int v){
        int fatherU = find(u);
        int fatherV = find(v);
        if(fatherU == fatherV){
            return;
        }else{
            father[fatherU] = fatherV;
        }
    }
}