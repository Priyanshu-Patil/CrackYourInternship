class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //Transpose
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse rows

        for (int i = 0; i < n; ++i) {
            int startI = 0;
            int endI = n - 1;

            while (startI < endI) {
                int temp = matrix[i][startI];
                matrix[i][startI] = matrix[i][endI];
                matrix[i][endI] = temp;
                startI++;
                endI--;
            }
        }
    }
}