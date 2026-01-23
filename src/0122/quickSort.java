class Solution {
    public int minPairSum(int[] nums) {
        int[] sorted = quickSort(nums);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<(nums.length/2); i++){
            int cur = sorted[i] + sorted[nums.length-1-i];
            ans = Math.max(ans,cur);
        }
        return ans;
        
    }

    public int[] quickSort(int[] array){
        int l = array.length;
        if(l == 0 || l == 1){
            return array;
        }
        int pivot = array[0];
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for(int i =1 ;i<l; i++){
            if(array[i]>=pivot){
                rightList.add(array[i]);
            }else{
                leftList.add(array[i]);
            }
        }

        int[] left = quickSort(leftList.stream().mapToInt(Integer::intValue).toArray());
        int[] right = quickSort(rightList.stream().mapToInt(Integer::intValue).toArray());

        System.arraycopy(left,0, array, 0, left.length);
        array[left.length] = pivot;
        System.arraycopy(right,0, array, left.length+1, right.length);
        return array;

    }
}