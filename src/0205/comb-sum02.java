class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>(); 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        for(int i= 0; i<candidates.length; i++){
            if(!map.containsKey(candidates[i])){
                list.add(candidates[i]);
                map.put(candidates[i], 1);
            } else{
                map.put(candidates[i], map.get(candidates[i])+1);
            }
        }

        int[] arr = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            arr[i] = list.get(i);
        }

        backtracing(0, arr, target, 0);
        return res;
    }

    public void backtracing(int index, int[] candidates, int target, int sum){
        if(containsNum(path, candidates[index]) > map.get(candidates[index])){
            return;
        }

        if(sum > target){
            return;
        }

        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i<candidates.length && sum<=target-candidates[i]; i++){
            path.add(candidates[i]);
            sum += candidates[i];
            backtracing(i,candidates, target, sum);
            sum -= candidates[i];
            path.remove(path.size()-1);
        }
    }

    public int containsNum(List<Integer> l, int k){
        int num = 0;
        for(Integer val: l){
            if (val == k){
                num++;
            }
        }
        return num;
    }
}