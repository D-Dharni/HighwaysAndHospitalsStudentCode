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

        // Array to keep track of the order for each tree
        int[] orderOfCities = new int[n];

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
            unionFind (start, end, arrOfRoots, orderOfCities);
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

    public static void unionFind (int start, int end, int[] arrOfRoots, int[] orderOfCities) {
        // Call separate function to find root of the start
        int rootStart = findParentRoot(start, arrOfRoots);

        // Call function to find root of the end
        int rootEnd = findParentRoot(end, arrOfRoots);

        // If the roots aren't in the same cluster then merge them together
        if (rootStart != rootEnd) {
            // Weight balance based off of the order

            // If the first cities order is bigger than the second
            if (orderOfCities[rootStart] >= orderOfCities[rootEnd]) {
                // Attach the rootEnd to rootStart
                arrOfRoots[rootEnd] = rootStart;

                // Increment the order of rootStart
                orderOfCities[rootStart] += orderOfCities[rootEnd];
            }

            // Opposite
            else {
                // Attach the rootStart to rootEnd
                arrOfRoots[rootStart] = rootEnd;

                // Increment the order of rootEnd
                orderOfCities[rootEnd] += orderOfCities[rootStart];
            }
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

        // Return the final parent
        return root;
    }
}
