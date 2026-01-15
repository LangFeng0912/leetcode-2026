class Solution {
    int maxVal = 0;

    public int maximalRectangle(char[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;

        for (int i = 0; i<row; i++) {
            int[] height = new int[col+2];
            for(int j = 0; j<col; j++){
                int k =i;
                while(k>=0 && matrix[k][j] == '1'){
                    height[j+1]++;
                    k--;
                }
            }
            System.out.println("!!!!");
            for(int s = 1; s<col+2; s++){
                System.out.print(height[s]);
                System.out.print(",");
            }
            //height 此时已经是原柱数组，变成求圆柱最大矩形面积
            maxRec(height);
        }
        return maxVal;
    }

    private void maxRec(int[] height){
        Deque<Integer> st = new LinkedList<>();
        st.push(0);
        for(int m = 1; m<height.length; m++){
            if(!st.isEmpty() && height[m]>=height[st.peek()]){
                st.push(m);
            } else{
                while(!st.isEmpty() && height[m]<height[st.peek()]){
                    int mid = st.pop();
                    if(!st.isEmpty()){
                        int left = st.peek();
                        int right = m;
                        int cur = height[mid]*(right-left-1);
                        if(cur > maxVal){
                            maxVal = cur;
                        }
                    }
                }
                st.push(m);
            }
        }

    }

    
}