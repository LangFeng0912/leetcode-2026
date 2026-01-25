class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minVal = arr[1] - arr[0];
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i< arr.length-1; i++){
            if((arr[i+1] - arr[i]) == minVal){
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i+1]);
                ans.add(cur);
            } else if((arr[i+1] - arr[i]) < minVal){
                ans = new ArrayList<>();
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i+1]);
                ans.add(cur);
                minVal = arr[i+1] - arr[i];
            } else{
                continue;
            }
        }

        return ans;
        
    }
}