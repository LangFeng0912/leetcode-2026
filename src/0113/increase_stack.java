class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] index = new int[nums1.length];
        int[] res = new int[nums1.length];
        for(int i = 0; i<nums1.length; i++){
            int j =0;
            while(j<nums2.length && nums2[j]!=nums1[i]){
                j++;
            }
            index[i] = j;
        }

        Deque<Integer> st = new LinkedList<>();
        int[] val = new int[nums2.length];
        Arrays.fill(val,-1);

        for(int t = 0; t<nums2.length; t++){
            while(!st.isEmpty() && nums2[t]>nums2[st.peek()]){
                int mid = st.pop();
                val[mid] = nums2[t];
            }
            st.push(t);
        }

        for(int i =0; i<nums1.length; i++){
            res[i] = val[index[i]];
        }

        return res;

    }
}