class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //to store the largest brick usage, so we can swap with a ladder if needed
        PriorityQueue<Integer> maxB = new PriorityQueue<>((a, b) -> b - a);
        
        int i = 0, diff = 0;
        
        for (i = 0; i < heights.length - 1; i++) {
            diff = heights[i + 1] - heights[i];
            
            if (diff <= 0) {
                continue; // No bricks or ladders needed
            }

            bricks -= diff; 
            maxB.add(diff); // Add the brick usage to the priority queue

            if (bricks < 0) {
                // Swap the largest brick usage with a ladder
                bricks += maxB.poll(); 
                ladders--;
            }

            if (ladders < 0) break; // Out of ladders, can't move further
        }
        
        return i;
    }
}
