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

        // Find connected parts using BFS

        // Compute the cost per cluster

            // For each cluster do hospitalCost + (clusterSize - 1) * highwayCost

        // Sum the total cost

        return 0;
    }
}
