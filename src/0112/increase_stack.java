class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int j = st.pop();
                res[j] = i-j;
            }
            st.push(i);
        }

        return res;
    }
}