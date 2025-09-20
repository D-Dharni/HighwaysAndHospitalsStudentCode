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
            return (long) n * hospitalCost;
        }

        // Start the union find process
        int[] arrOfRoots = new int[n];

        // Loop through each current city
        for (int i = 0; i < n; i++) {
            // Make each city its own root for now
            arrOfRoots[i] = i;
        }

        // Variables for highways built
        long highwaysBuilt = 0;

        // Correct all the roots (setup for cluster finding)
        for (int i = 0; i < cities.length; i++) {
            // Get the start and the end

            // Subtract 1 because the roots are set 1 less
            int start = cities[i][0] - 1;
            int end = cities[i][1] - 1;

            // Call union function to connect the cities
            unionFind (start, end, arrOfRoots);
        }

        // Count clusters
        int clusters = 0;
        for (int i = 0; i < n; i++) {
            // If the root of the city is itself then that is one component
            if (findParentRoot(i, arrOfRoots) == i) {
                // Increment counter
                clusters++;
            }
        }

        // Return the total cost
        return (long) clusters * hospitalCost + (long) (n-clusters) * highwayCost;
    }

    public static void unionFind (int start, int end, int[] arrOfRoots) {
        // Call separate function to find root of the start
        int rootStart = findParentRoot(start, arrOfRoots);

        // Call function to find root of the end
        int rootEnd = findParentRoot(end, arrOfRoots);

        // If the roots aren't in the same cluster then merge them together
        if (rootStart != rootEnd) {
            // Merge one end to another
            arrOfRoots[rootEnd] = rootStart;
        }
    }

    public static int findParentRoot (int city, int[] arrOfRoots) {
        // Start at city we want to find root for
        int root = city;

        // Is the current root pointing to itself
        while (arrOfRoots[root] != root) {
            // The new root becomes the parent of the current root
            root = arrOfRoots[root];
        }

        // Execute the path compression so future iterations can be done faster

        // Loop over all the cities we passed
        while (city != root) {
            // Save the current city's parent before changing it
            int parent = arrOfRoots[city];

            // Set the city to point directly to the root
            arrOfRoots[city] = root;

            // Move up the ladder
            city = parent;
        }

        return root;
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

    // Old Code

    /*
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
     */
}
