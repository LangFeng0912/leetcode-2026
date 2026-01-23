class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<tokens.length; i++){
            if(isNumber(tokens[i])){
                st.push(Integer.parseInt(tokens[i]));
            }else{
                int y = st.pop();
                int x = st.pop();
                int ans = op(x,y, tokens[i]);
                st.push(ans);
            }
        }

        return st.pop();
        
    }

    private boolean isNumber(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return false;
        }else{
            return true;
        }
    }

    private int op(int a, int b, String s){
        if(s.equals("+")){
            return a + b;
        } else if(s.equals("-")){
            return a-b;
        } else if(s.equals("*")){
            return a*b;
        } else {
            return a/b;
        }
    }
}