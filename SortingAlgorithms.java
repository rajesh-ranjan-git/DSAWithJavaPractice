public class SortingAlgorithms {
    public static void main(String[] args) {
        int arr[] = { 54, 8, 54, 98, 45, 68, 98, 52, 98 };

        printArray(arr);
        insertionSort(arr);
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
}
