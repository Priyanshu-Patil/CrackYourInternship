class Solution {
    public int Evaluate(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else if (op.equals("*")) return a * b;
        else return a / b;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (String token: tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b= s.peek();
                s.pop();
                int a = s.peek();
                s.pop();
                s.push(Evaluate(a, b, token));
            } else {
                s.push(Integer.parseInt(token));
            }
        }

        return s.peek();
    }
}