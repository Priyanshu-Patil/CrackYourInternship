import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        int dir = 0;

        while (top <= bottom && left <= right) {
            //left to right
            if (dir == 0) {
                for (int i = left; i <= right; ++i) {
                    ans.add(matrix[top][i]);
                }
                top++;
            }

            //top to bottom;
            if (dir == 1) {
                for (int i = top; i <= bottom; ++i) {
                    ans.add(matrix[i][right]);
                }
                right--;
            }

            //right to left
            if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //bottom to top
            if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }

            dir++;

            if (dir == 4) dir = 0;
        }

        return ans;
    }
}