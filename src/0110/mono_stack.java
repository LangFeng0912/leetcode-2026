class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] h = new int[n + 2];
        h[0] = 0;
        for (int i = 0; i < n; i++) h[i + 1] = heights[i];
        h[n + 1] = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[stack.peekLast()] > h[i]) {
                int mid = stack.pollLast();     
                int height = h[mid];

                int left = stack.peekLast();    
                int width = i - left - 1;       

                ans = Math.max(ans, height * width);
            }
            stack.addLast(i);
        }
        return ans;
    }
}