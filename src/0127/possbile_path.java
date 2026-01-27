class Solution {
    List<List<Integer>> result;
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        dfs(graph, 0);
        return result;
    }

    private void dfs(int[][] graph, int node){
        if(path.contains(node)){
            return;
        }
        path.add(node);
        if(node == graph.length -1){
            List<Integer> cur = new ArrayList<>(path);
            result.add(cur);
            return;
        }

        for(int i = 0; i<graph[node].length; i++){
            int nextNode = graph[node][i];
            dfs(graph, nextNode);
            path.removeLast();
        }
    }
}