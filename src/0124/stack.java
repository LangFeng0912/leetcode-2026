class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        //三维数组的意思：开始时间，结束时间，duration

        for(int i=0; i<logs.size(); i++){
            String[] curLog = logs.get(i).split("\\:");
            int func = Integer.parseInt(curLog[0]);
            int time = Integer.parseInt(curLog[2]);
            String op = curLog[1];

            if(op.equals("start")){
                if(!st.isEmpty()){
                    int[] pre = st.pop();
                    st.push(new int[]{pre[0], time, pre[2]+time-pre[1]});
                }
                st.push(new int[]{time,time,0});
            } else{
                int[] val = st.pop();
                int startTime = val[0];
                int curTime = val[1];
                int duration = val[2];
                if(duration == 0){
                    ans[func] += time - startTime + 1;
                } else{
                    ans[func] += duration + time - curTime +1;
                }     
                if(!st.isEmpty()){
                    int[] pre = st.pop();
                    st.push(new int[]{pre[0], time+1, pre[2]});
                }

            }
        }

        return ans;
        
    }
}