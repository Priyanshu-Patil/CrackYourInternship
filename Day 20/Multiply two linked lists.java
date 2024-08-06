class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        long num1 = 0;
        long num2 = 0;
        int mod = 1000000007;
        
        while (first != null || second != null) {
            if (first != null) {
                num1 = ((num1 * 10) % mod + (first.data) % mod) % mod;
                first = first.next;
            }
            
            if (second != null) {
                num2 = ((num2 * 10) % mod + (second.data) % mod) % mod;
                second = second.next;
            }
        }
        
        return (num1 % mod * num2 % mod) % mod;
    }
}