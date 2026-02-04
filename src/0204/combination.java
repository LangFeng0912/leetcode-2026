class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int totalSize;
    int totalLength;
    public List<List<Integer>> combine(int n, int k) {
        totalSize = k;
        totalLength = n;
        
        for(int i = 1; i<=totalLength; i++){
            backtrace(i);
        }

        return res;
    }

    public void backtrace(int node){
        if(path.contains(node)){
            return;
        }
        if(path.size() == totalSize-1){
            path.add(node);
            res.add(new ArrayList<Integer>(path));
            //rollback operation
            path.remove(path.size()-1);
            return;
        }

        path.add(node);
        for(int j = node+1; j<=totalLength-(totalSize-path.size())+1; j++){
            backtrace(j);
        }

        path.remove(path.size()-1);
    }
}