class Solution {
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k) {
        String[] max = {""};
        combs(str, k, 0, max);
        
        return max[0];
    }
    
    public static void combs(String str, int k, int index, String[] max) {
        if (k == 0 || index == str.length() - 1) {
            if (str.compareTo(max[0]) > 0) {
                max[0] = str;
            }
            
            return;
        }
        
        for (int i = index + 1; i < str.length(); ++i) {
            if (str.charAt(index) < str.charAt(i)) {
                str = swap(index, i, str);
                combs(str, k - 1, index + 1 ,max);
                str = swap(i, index, str);
            }
        }
        
        combs(str, k, index + 1, max);
    }
    
    public static String swap(int a, int b, String s) {
        char[] temp = s.toCharArray();
        char c = temp[a];
        temp[a] = temp[b];
        temp[b] = c;
        
        return new String(temp);
    }
}