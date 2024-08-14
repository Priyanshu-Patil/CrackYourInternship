class Solution {
    public int nthUglyNumber(int n) {
        int[] t = new int[n + 1];
        t[1] = 1; // The first Ugly number is 1

        // Initialize indices for 2, 3, and 5
        int i2 = 1, i3 = 1, i5 = 1;

        for (int i = 2; i <= n; i++) {
            // Calculate the next possible Ugly numbers by multiplying with 2, 3, and 5
            int i2thUgly = t[i2] * 2;
            int i3rdUgly = t[i3] * 3;
            int i5thUgly = t[i5] * 5;

            // The next Ugly number is the minimum of these
            t[i] = Math.min(Math.min(i2thUgly, i3rdUgly), i5thUgly);

            // Increment the corresponding index
            if (t[i] == i2thUgly) i2++;
            if (t[i] == i3rdUgly) i3++;
            if (t[i] == i5thUgly) i5++;
        }

        return t[n];
    }
}
