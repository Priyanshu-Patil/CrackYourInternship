class Solution {
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S) {
        Stack<Integer> st = new Stack<>();
        
        for (char s: S.toCharArray()) {
            int ans = 0;
            
            if (s >= '0' && s <= '9') {
                int num = s - '0';
                st.push(num);
            } else {
                int num1 = st.peek();
                st.pop();
                int num2 = st.peek();
                st.pop();
                
                switch(s){
                    case '+':
                        ans = num2+num1;
                        st.push(ans);
                        break;
                    case '*':
                        ans = num2*num1;
                        st.push(ans);
                        break;
                    case '-':
                        ans = num2-num1;
                        st.push(ans);
                        break;
                    case '/':
                        ans = num2/num1;
                        st.push(ans);
                        break;
                }
            }
        }
        
        return st.peek();
    }
}