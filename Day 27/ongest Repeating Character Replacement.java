class Solution {
    public int characterReplacement(String s, int k) {
        //array to store count of char in s
        int[] arr = new int[26];
        int res = 0;
        int max = 0;
        int l = 0;
        
        for (int r = 0; r < s.length(); ++r) {
            //count no. of each char in string
            arr[s.charAt(r) - 'A']++;

            //check char with max occurence
            max = Math.max(max, arr[s.charAt(r) - 'A']);

            if (r - l + 1 - max > k) {
                //no. of replacements in more than allowed (k)
                arr[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}