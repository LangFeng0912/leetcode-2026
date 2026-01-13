class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] val = new int[n];
        for(int t =0; t<n; t++){
            val[t] = -1;
        }

        Deque<Integer> st = new LinkedList<>();

        for(int i = 0; i< 2*n; i++){
            int j = i%n;
            while(!st.isEmpty() && nums[j]>nums[st.peek()]){
                val[st.pop()] = nums[j];
            }
            if(val[j]==-1){
                st.push(j);
            }
        }

        return val;
        
    }
}