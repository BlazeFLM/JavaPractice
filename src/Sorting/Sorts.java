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
        int[] ts = {17, 15, 19, 32, 2, 26, 41, 17, 17};
        Sorts s = new Sorts(ts);
        s.printList();
        s.insertionSort();
        s.printList();

    }

    /**
     * In-place insertion sort
     * Best case: Θ(N) - already sorted, still have to go through all
     * Worst case: Θ(N^2) - swap N times with every element of N
     * Observations:
     * Each swap in Insertion Sort reduces the number of inversions by 1
     * Insertion sort is REALLY fast on arrays with small number of inversions
     * basically on ALMOST sorted arrays, runtime is Θ(N + K), K = # of inversions
     */
    public void insertionSort() {
        int swaps = 0;
        for (int examined = 1; examined < arr.length; examined++) {
            for (int traveller = examined; traveller > 0; traveller--) {
                if (arr[traveller] < arr[traveller - 1]) {
                    swap(traveller, traveller - 1);
                    swaps++;
                } else {
                    break;
                }
            }
        }
        System.out.println("Inversions: " + swaps);
    }

    /**
     * Hoare Partitioning:
     * L stops on items >= pivot
     * pivot -> (first item, but median results in faster overall runtime)
     * G stops on items <= pivot
     * Walk pointers towards each other
     * When pointers both stop, swap and move pointers by one
     * When pointers cross stop and swap element G with pivot
     * Time complexity: Θ(N) Space complexity: Θ(1)
     * Bad for mostly sorted, reverse sorted
     * If almost sorted just use insertion sort probably
     * Use median instead of leftmost element
     * Arrays of duplicates can cause Θ(N^2) behavior
     */
    public void hoarePartitioning() {
        int pivot = arr[0];
        int L = 1;
        int G = arr.length - 1;
        boolean lStop = false;
        boolean gStop = false;
        while (L <= G) {
            if (arr[L] >= pivot) {
                lStop = true;
            } else {
                L++;
            }
            if (arr[G] <= pivot) {
                gStop = true;
            } else {
                G--;
            }
            if (lStop && gStop) {
                swap(L, G);
                L++;
                G--;
            }
        }
        swap(G, 0);
    }

    public void quickSort(){

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
