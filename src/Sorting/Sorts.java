package Sorting;

/*
 * Sorting : Given a sequence of elements with Z inversions,
 * perform a sequence of operations that reduces inversions to 0.
 * Worst case # of inversions for input N: N * (N-1) / 2 (reverse sorted order)
 * That's just N^2 - swap every item with every item
 *
 * Imagine a sorted array of 1,000,000 integers,
 * and we randomly change one, then resort.
 * Out of selection, heap, merge, and insertion, which is the best one?
 * Here we would have N-1 inversions Θ(n) inversions
 * Insertion sort is fastest, we will only do as much work as needed
 * Others like heapsort will make a big heap and merge will break it up and
 * whatever, too much divide and conquer
 */

public class Sorts {
    int[] arr;

    public Sorts(int[] arr) {
        this.arr = arr;
    }

    static void main() {
        int[] ts = {123, 2171, 271, 192, 347, 812, 6153, 832, 975};
        Sorts s = new Sorts(ts);
        s.printList();
        s.insertionSort();
        s.printList();

    }

    // In-place insertion sort
    // Best case: Θ(N) - already sorted, still have to go through all
    // Worst case: Θ(N^2) - swap N times with every element of N
    // Observations:
    // Each swap in Insertion Sort reduces the number of inversions by 1
    // Insertion sort is REALLY fast on arrays with small number of inversions
    // basically on ALMOST sorted arrays, runtime is Θ(N + K), K = # of inversions

    public void insertionSort() {
        int inversions = 0;
        for (int examined = 1; examined < arr.length; examined++) {
            for (int traveller = examined; traveller > 0; traveller--) {
                if (arr[traveller] < arr[traveller - 1]) {
                    swap(traveller, traveller - 1);
                    inversions++;
                } else {
                    break;
                }
            }
        }
        System.out.println("Inversions: " + inversions);
    }


    // Helper swap method for sorting methods
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void printList() {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }


}
