class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        for (int[] p : points) {
            int x = p[0], y = p[1];
            int distance = x * x + y * y;
            
            // Add point to the max-heap
            maxHeap.offer(new int[]{distance, x, y});
            
            // If heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] top = maxHeap.poll();
            result[i][0] = top[1];
            result[i][1] = top[2];
        }
        
        return result;
    }
}