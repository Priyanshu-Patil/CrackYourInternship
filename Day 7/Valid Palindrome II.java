class Solution {
    boolean palindrome(String s, int left, int right) {
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return palindrome(s, left + 1, right) || palindrome(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}