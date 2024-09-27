public class BitonicArray {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 11, 16, 13, 11, 9, 4, 3, 2, 1 };
        minElement(arr);
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

    static void minElement(int arr[]) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print(
                ((arr[0] > arr[arr.length - 1]) ? arr[arr.length - 1] : arr[0]) + " is the minimum element in Bitonic Array ");
        printArray(arr);
    }
}
