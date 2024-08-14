class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // If the initial fuel is already enough to reach the target, no refuel is needed
        if (startFuel >= target) return 0;

        //to store fuel amounts, ordered by maxHeap
        PriorityQueue<Integer> fuelMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        int stationIndex = 0;
        int numberOfStations = stations.length;
        int refuelStops = 0;
        int currentDistance = startFuel;

        
        while (currentDistance < target) {
            // Add all reachable fuel stations to the max heap
            while (stationIndex < numberOfStations && stations[stationIndex][0] <= currentDistance) {
                fuelMaxHeap.offer(stations[stationIndex][1]);
                stationIndex++;
            }

            // If no more reachable fuel stations and cannot reach the target, return -1
            if (fuelMaxHeap.isEmpty()) return -1;

            // Refuel with the largest available fuel from the max heap
            currentDistance += fuelMaxHeap.poll();
            refuelStops++;
        }

        // Return the number of refuel stops made to reach the target
        return refuelStops;
    }
}