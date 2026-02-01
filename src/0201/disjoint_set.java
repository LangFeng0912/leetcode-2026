class Solution {
    int[] father;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        father = new int[n];
        for(int i =0; i<n; i++){
            father[i] = i;
        }

        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            join(u,v);
        }

        return connected(source, destination);

    }

    public void join(int u, int v){
        int fatherU = find(u);
        int fatherV = find(v);
        if(fatherU == fatherV) {
            return;
        } else {
            father[fatherU] = fatherV;
        }
    }

    public int find(int u){
        if (father[u] == u) {
            return u;
        }
        father[u] = find(father[u]);
        return father[u];
    }

    public boolean connected(int u, int v){
        return find(u) == find(v);
    }
}