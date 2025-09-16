import java.util.ArrayList;
import java.util.List;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Deven Dharni
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {

        // If hospitals cost less than highways then (n) * hospital cost
        if (hospitalCost < highwayCost) {
            return n * hospitalCost;
        }

        // For each city have a list of its neighbors for easy access
        List<List<Integer>> adjacencyGraph= new ArrayList<>();

        // Loop through each city and add an empty list for each city
        for (int i = 0; i < n+1; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            adjacencyGraph.add(arr);
        }

        // Fill in the adjacencyGraph by using cities[][]

        for (int i = 0; i < cities.length; i++) {
            // Create variables for better fluency
            int firstPair = cities[i][0];
            int secondPair = cities[i][1];

            // Update the first pair's to the second
            List<Integer> current = adjacencyGraph.get(firstPair);
            current.add(secondPair);

            // Update the second pair's to the first
            current = adjacencyGraph.get(secondPair);
            current.add(firstPair);
        }

        // Create an array for visited cities
        boolean[] visitedCities = new boolean[n+1];

        // Set the cost variable
        double totalCost = 0;

        // Start to loop through the all the cities
        for (int i = 1; i < n+1; i++) {
            // First check if you haven't visited the item
            if (visitedCities[i] = false) {
                // Start BFS by calling the BFS function
            }
        }

        return 0;
    }

    public static int bfs(List<List<Integer>> adjacencyGraph, int start, boolean visited) {
        // Make the queue

        // Set the city count to 0

        // Add the start city to the queue

        // Set it's visited to true

        // Increment the city counter

        // While the queue isn't empty

            // Poll the first city

            // Loop through the neighbors of the adjacent cities

                // Check if you haven't visited the neighbor

                    // Set the neighbor's visited to true

                    // Add the neighbor to the queue

                    // Increment the city count

        // Return the city count

        return -1;
    }
}
