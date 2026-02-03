class Solution {
    int[] father;
    int[][] gEdges;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = 1;
        gEdges = edges;
        for(int i = 0; i<edges.length; i++){
            n = Math.max(n, edges[i][0]);
            n = Math.max(n, edges[i][1]);
        }

        int[] nodes = new int[n];
        for(int i = 0; i<edges.length; i++){
            nodes[edges[i][1]-1]++;
        }

        int node = -1;
        for(int i =0; i<n; i++){
            if(nodes[i] == 2){
                node = i;
            }
        }

        System.out.println(node);

        father = new int[n];
        for(int i = 0; i<n; i++){
            father[i] = i;
        }

        List<Integer> proEdges = new ArrayList<>();
        for(int i = 0; i<edges.length; i++){
            if(edges[i][1] == node+1){
                proEdges.add(i);
            }
        }

        System.out.println(proEdges.size());

        if(proEdges.size()!=0){
            if(isTreeGood(proEdges.get(1))){
                return edges[proEdges.get(1)];
            }
            return edges[proEdges.get(0)];
        }


        for(int i = 0; i<edges.length; i++){
            if(connected(edges[i][0]-1, edges[i][1]-1)){
                return edges[i];
            }
            join(edges[i][0]-1, edges[i][1]-1);
        }

        return null;
        
    }

    public boolean isTreeGood(int k){
        for(int i = 0; i<gEdges.length; i++){
            if(i == k){
                continue;
            }
            if(connected(gEdges[i][0]-1, gEdges[i][1]-1)){
                return false;
            }
            join(gEdges[i][0]-1, gEdges[i][1]-1);
        }
        return true;
    }


    public int find(int i){
        if(father[i] == i){
            return i;
        }
        father[i] = find(father[i]);
        return father[i];
    }

    public boolean connected(int u, int v){
        return find(u) == find(v);
    }

    public void join(int u, int v){
        int fatherU = find(u);
        int fatherV = find(v);
        if(fatherU == fatherV){
            return;
        }
        father[fatherV] = fatherU;
    }


}