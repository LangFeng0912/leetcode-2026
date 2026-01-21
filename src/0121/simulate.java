class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            list.add(nums[i]);
        }

        int count = 0;

        while(list.size() > 1){
            int k = list.size();
            int index = 0;
            int minVal = Integer.MAX_VALUE;
            boolean sorted = true;

            for(int i = 0; i<k-1; i++){
                if(list.get(i+1)<list.get(i)){
                    sorted = false;
                }

                int cur = list.get(i+1) + list.get(i);
                if (cur < minVal){
                    minVal = cur;
                    index = i;
                }
            }

            System.out.println(index);

            if (sorted){
                break;
            }

            count++;
            list.set(index, minVal);
            list.remove(index+1);
        }

        return count;
        
    }
}