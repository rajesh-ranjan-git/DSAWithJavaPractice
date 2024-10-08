public class BitonicArray {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 11, 16, 13, 11, 9, 4, 3, 2, 1 };
        // minElement(arr);
        System.out.print("Found peak element " + arr[findPeakElement(arr)] + " at " + findPeakElement(arr) + " in ");
        printArray(arr);
        // searchElementInBitonicArray(arr, 9);
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
                ((arr[0] > arr[arr.length - 1]) ? arr[arr.length - 1] : arr[0])
                        + " is the minimum element in Bitonic Array ");
        printArray(arr);
    }

    static int findPeakElement(int arr[]) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + arr.length) % arr.length;
            int next = (mid + 1) % arr.length;
            if (arr[mid] > arr[prev] && arr[mid] > arr[next]) {
                ans = mid;
                break;
            } else if (arr[mid] > arr[prev]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    static int binarySearchAscending(int arr[], int target) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    
    static int binarySearchDescending( int arr[], int target) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    static void searchElementInBitonicArray(int arr[], int target) {
        int peakIndex = findPeakElement(arr);
        int index = -1;
        
        if (target == arr[peakIndex]) {
            System.out.print("Found " + target + " at index " + peakIndex + " in ");
            printArray(arr);
            return;
        } else {
            index = binarySearchAscending(arr, target);

            if (index != -1) {
                System.out.print("Found " + target + " at index " + index + " in ");
                printArray(arr);
                return;
            }

            index = binarySearchDescending(arr, target);
        }
        
        if (index == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.print("Found " + target + " at index " + index + " in ");
            printArray(arr);
        }
    }
}
