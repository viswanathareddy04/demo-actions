// File: BinarySearch.java

public class BinarySearch {

    public static void main(String[] args) {
        // Sample sorted array to search within
        int[] sortedArr = { 11, 12, 22, 25, 34, 64, 90 };

        System.out.println("Array: ");
        printArray(sortedArr);

        int key1 = 22;
        int key2 = 35;

        // Approach 1: Recursive Binary Search
        int idx1 = binarySearchRecursive(sortedArr, key1, 0, sortedArr.length - 1);
        System.out.println("\nRecursive search for " + key1 + ": " +
                (idx1 >= 0 ? "Found at index " + idx1 : "Not found"));

        // Approach 2: Iterative Binary Search
        int idx2 = binarySearchIterative(sortedArr, key1);
        System.out.println("Iterative search for " + key1 + ": " +
                (idx2 >= 0 ? "Found at index " + idx2 : "Not found"));

        // Demonstrate search for a value not present
        int idx3 = binarySearchIterative(sortedArr, key2);
        System.out.println("\nIterative search for " + key2 + ": " +
                (idx3 >= 0 ? "Found at index " + idx3 : "Not found"));
    }

    /**
     * Approach 1: Recursive Binary Search
     * Repeatedly divides the search interval in half.
     * @param arr   Sorted array to search
     * @param key   Value to find
     * @param low   Lower index of the current search interval
     * @param high  Upper index of the current search interval
     * @return      Index of key if found; otherwise -1
     */
    public static int binarySearchRecursive(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1; // Base case: interval is empty → not found
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) {
            return mid; // Found the key
        } else if (arr[mid] > key) {
            // Search left half
            return binarySearchRecursive(arr, key, low, mid - 1);
        } else {
            // Search right half
            return binarySearchRecursive(arr, key, mid + 1, high);
        }
    }

    /**
     * Approach 2: Iterative Binary Search
     * Uses a loop instead of recursion to avoid call-stack overhead.
     * @param arr   Sorted array to search
     * @param key   Value to find
     * @return      Index of key if found; otherwise -1
     */
    public static int binarySearchIterative(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid; // Found the key
            } else if (arr[mid] < key) {
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        return -1; // Not found
    }

    /** Utility to print array contents */
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
