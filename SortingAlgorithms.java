public class SortingAlgorithms {
    public static void main(String[] args) {
        // int arr[] = { 54, 8, 54, 98, 45, 68, 98, 52, 98 };
        int arr[] = { 2, 7, 1, 5, 8, 1, 12 };

        // printArray(arr); // Time Complexity : O(N^2)
        // insertionSort(arr); // Time Complexity : O(N^2)
        // selectionSort(arr); // Time Complexity : O(N^2)
        // selectionSortBiDirectional(arr); // Time Complexity : O(N^2)
        // bubbleSort(arr); // Time Complexity : O(N^2)
        // bubbleSortOptimized(arr); // Time Complexity : O(N^2)
        // brickSort(arr); // Time Complexity : O(N^2)
        countingSort(arr); // Time Complexity : O(N + K)
        // printArray(arr);
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
        // This sort is also called no comparison algorithm and is not considered good and it wastes too much spaces and cannot handle negative numbers.

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
    
    static void swap (int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
