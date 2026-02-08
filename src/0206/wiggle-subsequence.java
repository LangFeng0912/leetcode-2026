class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        if(nums.length == 2) {
            if(nums[0] == nums[1]){
                return 1;
            }
            return 2;
        }

        int preDiff = 0;
        int curDiff = 0;
        int res = 1;
        for(int i = 1; i<nums.length; i++){
            curDiff = nums[i] - nums[i-1];

            if((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)){
                res ++;
                preDiff = curDiff;
            }
        }

        return res;
    }
}