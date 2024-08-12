class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int candidate = 0;
        
        // find the candidate
        for (int i = 1; i < n; ++i) {
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
        }
        
        // Verify the candidate
        for (int i = 0; i < n; ++i) {
            if (i != candidate) {
                if (mat[i][candidate] == 0 || mat[candidate][i] == 1) {
                    return -1;
                }
            }
        }
        
        return candidate;
    }
}