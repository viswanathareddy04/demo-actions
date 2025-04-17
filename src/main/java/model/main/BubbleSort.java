package model.main;// File: BubbleSort.java

public class BubbleSort {

    public static void main(String[] args) {
        int[] data = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Original array:");
        printArray(data);

        // Approach 1: Standard bubble sort
        int[] copy1 = data.clone();
        bubbleSortBasic(copy1);
        System.out.println("\nSorted with basic bubble sort:");
        printArray(copy1);

        // Approach 2: Optimized bubble sort (early exit + shrinking boundary)
        int[] copy2 = data.clone();
        bubbleSortOptimized(copy2);
        System.out.println("\nSorted with optimized bubble sort (most effective):");
        printArray(copy2);
    }

    /**
     * Standard Bubble Sort
     * Repeatedly steps through the list, compares adjacent elements and swaps them
     * if they are in the wrong order. Always makes n-1 passes.
     */
    public static void bubbleSortBasic(int[] arr) {
        int n = arr.length;
        // Outer loop for number of passes
        for (int pass = 1; pass < n; pass++) {
            // Inner loop for pairwise comparisons
            for (int i = 0; i < n - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap arr[i] and arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    /**
     * Optimized Bubble Sort
     * 1) Tracks if any swap was made in a pass; if no swap, the array is already sorted → early exit.
     * 2) Reduces the range of comparisons each pass, since the largest elements “bubble up” to the end.
     */
    public static void bubbleSortOptimized(int[] arr) {
        int n = arr.length;
        // lastUnsorted tracks the boundary of unsorted portion
        for (int lastUnsorted = n - 1; lastUnsorted > 0; lastUnsorted--) {
            boolean swapped = false;
            // Only iterate up to the last unsorted element
            for (int i = 0; i < lastUnsorted; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap adjacent elements
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, array is sorted → break early
            if (!swapped) {
                break;
            }
        }
    }

    /** Utility to print array contents */
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
