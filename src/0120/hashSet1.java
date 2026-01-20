class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> correctSet = new HashSet<>();
        HashSet<Integer> curSet = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            correctSet.add(i+1);
            curSet.add(nums[i]);
        }

        correctSet.removeAll(curSet);
        List<Integer> ans = new ArrayList<>();
        for(int val: correctSet){
            ans.add(val);
        }
        return ans;
        
    }
}