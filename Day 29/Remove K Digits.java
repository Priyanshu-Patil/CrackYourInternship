class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char digit: num.toCharArray()) {
           while (!s.isEmpty() && k > 0 && s.peek() > digit) {
                s.pop();
                k--;
            }

            s.push(digit);
        }

        for (int i = 0; i < k; i++) {
            s.pop();
        }

        boolean leadingZero = true;

        for (char digit: s) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            ans.append(digit);
        }

        if (ans.length() == 0) return "0";

        return ans.toString();
    }
}