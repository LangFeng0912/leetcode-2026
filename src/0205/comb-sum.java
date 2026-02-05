class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracing(0, candidates, target);
        return res;
    }

    public void backtracing(int index, int[] candidates, int target){
        if(sumList(path) > target){
            return;
        }

        if(sumList(path) == target){
            res.add(new ArrayList<>(path));
        }

        for(int i = index; i<candidates.length; i++){
            path.add(candidates[i]);
            backtracing(i, candidates, target);
            path.remove(path.size()-1);
        }
    }

    private int sumList(List<Integer> list){
        int sum = 0;
        for(Integer x: list){
            sum += x;
        }
        return sum;
    }
}