class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        int[] ans = new int[n];
        for(int i = 0; i<n-1; i++){
            int j = i+1;
            int curVal = sorted[j];
            while((j>=1) && curVal<sorted[j-1]){
                sorted[j] = sorted[j-1];
                sorted[j-1] = curVal;
                j--;
            }
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            if(map.containsKey(sorted[i])){
                continue;
            }
            map.put(sorted[i],i);
        }

        for(int i =0; i<n; i++){
            ans[i] = map.get(nums[i]);
        }

        return ans;
        
    }
}