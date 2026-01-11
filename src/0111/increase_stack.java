class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for(int i = 1; i<n; i++) {
            if(height[i]<=height[st.peek()]){
                st.push(i);
            } else{
                while(!st.isEmpty() && height[i]>height[st.peek()]){
                    int mid = st.pop();
                    if(!st.isEmpty()){
                        int left = st.peek();
                        int h = Math.min(height[i], height[left]) - height[mid];
                        int width = i - left -1;
                        res += h * width;
                    }
                }
                st.push(i);
            }
        }

        return res;
    }
}