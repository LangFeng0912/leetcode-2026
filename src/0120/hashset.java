class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> curSet = new HashSet<>();
        Set<Integer> correctSet = new HashSet<>();

        int[] ans = new int[2];

        for(int i =0; i<nums.length; i++){
            if(curSet.contains(nums[i])){
                ans[0] = nums[i];
            }
            curSet.add(nums[i]);
            correctSet.add(i+1);
        }

        correctSet.removeAll(curSet);
        for(int i: correctSet){
            ans[1] = i;
        }
        return ans;
    }
}