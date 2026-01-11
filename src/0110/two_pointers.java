class Solution {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        if (size == 0) return 0;

        int[] minLeftIndex = new int[size];
        int[] minRightIndex = new int[size];

        minLeftIndex[0] = -1; 
        for (int i = 1; i < size; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) {
                t = minLeftIndex[t];
            }
            minLeftIndex[i] = t;
        }

        minRightIndex[size - 1] = size; 
        for (int i = size - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < size && heights[t] >= heights[i]) {
                t = minRightIndex[t];
            }
            minRightIndex[i] = t;
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            int area = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
            result = Math.max(result, area);
        }

        return result;
    }
}
