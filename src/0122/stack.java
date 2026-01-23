class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int j = 0;

        for(int i = 1; i<=n; i++){
            st.push(i);
            ans.add("Push");
            if(j == target.length-1 && st.peek() == target[j]){
                return ans;
            } else if (j < target.length-1 && st.peek() == target[j]){
                j++;
                continue;
            } else{
                st.pop();
                ans.add("Pop");
            }
        }

        return ans;

    }
}