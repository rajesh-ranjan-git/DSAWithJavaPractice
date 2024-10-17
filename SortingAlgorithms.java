public class SortingAlgorithms {
    public static void main(String[] args) {
        int arr[] = { 54, 8, 54, 98, 45, 68, 98, 52, 98 };
        // int arr[] = { 2, 7, 1, 5, 8, 1, 12 };
        // int arr[] = { 2, 3, 1, 5, 4 };
        // int arr[] = { 2, 3, 1, 5, 4, 0 };

        printArray(arr);
        // insertionSort(arr); // Time Complexity : O(N^2)
        // selectionSort(arr); // Time Complexity : O(N^2)
        // selectionSortBiDirectional(arr); // Time Complexity : O(N^2)
        // bubbleSort(arr); // Time Complexity : O(N^2)
        // bubbleSortOptimized(arr); // Time Complexity : O(N^2)
        // brickSort(arr); // Time Complexity : O(N^2)
        // countingSort(arr); // Time Complexity : O(N + K)
        // radixSort(arr); // Time Complexity : O(N) + O(D(N + K)) -> D = size of max digit, K = 9
        // pigeonholeSort(arr); // Time Complexity : O(N + K), Space Complexity : O(N + K) -> N is no. of input so we can consider O(K)
        // cycleSort1ToN(arr); // Range is 1 to N, Time Complexity : O(N), Space complexity : O(1), This is a variant of Cycle Sort.
        // cycleSort0ToN(arr); // Range is 0 to N, Time Complexity : O(N), Space complexity : O(1), This is a variant of Cycle Sort.
        cycleSort(arr); // Time Complexity : O(N^2)
        printArray(arr);
    }

    static void printArray(int arr[]) {
        System.out.print("arr : [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("]");
            }
        }
        System.out.println();
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];

            // shifting logic
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // place key at j + 1
            arr[j + 1] = key;
        }
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minEl = arr[i];
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (minEl > arr[j]) {
                    minEl = arr[j];
                    minIdx = j;
                }
            }
            // swap min element
            swap(arr, minIdx, i);
        }
    }

    static void selectionSortBiDirectional(int[] arr) {
        int k = arr.length - 1;
        for (int i = 0; i < k; i++) {
            int minEl = arr[i];
            int minIdx = i;
            int maxEl = arr[i];
            int maxIdx = i;
            for (int j = i + 1; j <= k; j++) {
                if (minEl > arr[j]) {
                    minEl = arr[j];
                    minIdx = j;
                } else if (maxEl < arr[j]) {
                    maxEl = arr[j];
                    maxIdx = j;
                }
            }
            // swap min element         
            swap(arr, minIdx, i);

            // swap max element considering edge case
            if (maxEl == arr[minIdx]) {
                swap(arr, minIdx, k);
            } else {
                swap(arr, maxIdx, k);
            }
            k--;
        }
    }

    static void bubbleSort(int[] arr) {
        int passes = arr.length - 2;
        for (int i = 0; i < passes; i++) {
            for (int j = 0; j < passes - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static void bubbleSortOptimized(int[] arr) {
        int passes = arr.length - 2;
        for (int i = 0; i < passes; i++) {
            boolean flag = false;
            for (int j = 0; j < passes - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                // If no swap done
                break;
            }
        }
    }

    static void brickSort(int[] arr) {
        //This sorting algorithm is also called Odd-Even Sort or Parity Sort.
        boolean isSorted = false;
        while (!isSorted) {
            boolean flag = false;
            // swap even elements
            for (int i = 0; i < arr.length - 1; i+=2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            // swap odd elements
            for (int i = 1; i < arr.length - 1; i+=2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            if (!flag) {
                isSorted = true;
            }
        }
    }

    static void countingSort(int[] arr) {
        // This sort is also called no comparison algorithm and is not considered good and it wastes too much spaces and cannot handle negative numbers. It is not in-place sorting.

        int k = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k) {
                k = arr[i];
            }
        }

        // Empty array or maximum element is not findable.
        if (k == Integer.MIN_VALUE) {
            return;
        }

        int[] countArr = new int[k + 1];

        // Find frequency
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            countArr[index]++;
        }

        // Find cumulative frequency
        for (int i = 1; i <= k; i++) {
            countArr[i] += countArr[i - 1];
        }

        int[] res = new int[arr.length];
        // Sorted Array
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = --countArr[arr[i]];
            res[index] = arr[i];
        }
        System.out.print("Sorted ");
        printArray(res);
    }

    static void countingSort(int[] arr, int digit) {
        int k = 9;
        int[] countArr = new int[k + 1];

        // Find frequency
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] / digit) % 10;
            countArr[index]++;
        }

        // Find cumulative frequency
        for (int i = 1; i <= k; i++) {
            countArr[i] += countArr[i - 1];
        }

        int[] res = new int[arr.length];
        // Sorted Array
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = --countArr[(arr[i] / digit) % 10];
            res[index] = arr[i];
        }

        // Copy back to original array.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }

    static void radixSort(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Empty array or maximum element is not findable.
        if (max == Integer.MIN_VALUE) {
            return;
        }

        for (int digit = 1; max / digit > 0; digit *= 10) {
            countingSort(arr, digit);
        }      
    }

    static void pigeonholeSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Empty array or maximum or minimum element is not findable.
        if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
            return;
        }

        int[] pigeonhole = new int[max - min + 2];

        // Find frequency
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - min;
            pigeonhole[index]++;
        }

        // Fill the original array
        int insertionIndex = 0;
        for (int j = 0; j < max - min + 1; j++) {
            while (pigeonhole[j] > 0) {
                arr[insertionIndex] = j + min;
                insertionIndex++;
                pigeonhole[j]--;
            }
        }
    }

    static void cycleSort1ToN(int[] arr) { // for range 1 to n
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            int actualPos = element - 1;
            if (arr[index] < n && arr[index] != arr[actualPos]) {
                swap(arr, index, actualPos);
            } else {
                index++;
            }
        }
    }

    static void cycleSort0ToN(int[] arr) { // for range 0 to n
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            int actualPos = element;
            if (arr[index] < n && arr[index] != arr[actualPos]) {
                swap(arr, index, actualPos);
            } else {
                index++;
            }
        }
    }

    static void cycleSort(int[] arr) {
        // This is very unstable algorithm.
        for (int cycles = 0; cycles < arr.length - 1; cycles++) {
            int pos = cycles;
            int item = arr[cycles];

            // Find number of smaller elements
            for (int i = cycles + 1; i < arr.length; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            // Element is at correct position
            if (pos == cycles) {
                continue;
            }

            // Ignore duplicates
            while (arr[pos] == item) {
                pos++;
            }

            // If smaller elements are found perform swapping
            if (pos != cycles) {
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }

            // Check if more swaps are required
            while (pos != cycles) {
                pos = cycles;

                // Find number of smaller elements
                for (int i = cycles + 1; i < arr.length; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                // Ignore duplicates
                while (arr[pos] == item) {
                    pos++;
                }

                if (item != arr[pos]) {
                    int temp = arr[pos];
                    arr[pos] = item;
                    item = temp;
                }
            }
        }
    }

    static void swap (int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
