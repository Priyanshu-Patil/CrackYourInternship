class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int carry = 0;

        StringBuilder res = new StringBuilder();

        while (n1 >= 0 || n2 >= 0 || carry == 1) {

            if (n1 >= 0) carry += a.charAt(n1--) - '0';
            if (n2 >= 0) carry += b.charAt(n2--) - '0';

            res.append(carry % 2);
            carry /= 2;
        }

        return res.reverse().toString();
    }
}