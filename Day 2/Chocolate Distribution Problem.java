import java.util.ArrayList;
import java.util.Collections;

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long mini = Long.MAX_VALUE;
        long i = 0, j = m - 1;

        while (j < n) {
            mini = Math.min(mini, a.get((int) j) - a.get((int) i));
            i++;
            j++;
        }

        return mini;
    }
}