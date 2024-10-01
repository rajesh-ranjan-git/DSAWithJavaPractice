public class SortedRotatedArray_153_154 {
    public static void main(String[] args) {
        int arr1[] = { 43, 2, 4, 5, 7, 11 };
        int arr2[] = { 43, 2, 2, 4, 4, 5, 7, 11 };
        int arr3[] = { 3, 3, 3, 1, 3 };
        minElement(arr1);
        minElementWithDuplicate(arr2);

        int index = minElementEdgeCase(arr3);
        System.out.print("Minimum element is " + arr3[index] + " at index " + index + " in ");
        printArray(arr3);

        maxElement(arr1);
        maxElement(arr2);
        maxElement(arr3);

        clockWiseRotationCount(arr3);
        anticlockWiseRotationCount(arr3);

        searchElement(arr1, 5);
        searchElement(arr2, 5);
        searchElement(arr3, 1);
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
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + ((end - start) / 2);

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                start = mid;
                break;
            } else if (arr[mid] < arr[end]) {
                // if right half is sorted, move left
                end = mid - 1;
            } else {
                // if left half is sorted, move right
                start = mid + 1;
            }
        }

        System.out.print("Minimum element is " + arr[start] + " at index " + start + " in ");
        printArray(arr);
    }

    static void minElementWithDuplicate(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + ((end - start) / 2);
            
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                start = mid;
                break;
            } else if (arr[mid] <= arr[end]) {
                // if right half is sorted, move left
                end = mid - 1;
            } else {
                // if left half is sorted, move right
                start = mid + 1;
            }
        }

        System.out.print("Minimum element is " + arr[start] + " at index " + start + " in ");
        printArray(arr);
    }

    static int minElementEdgeCase(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + ((end - start) / 2);

            // When start and end are equal, we skip them to decrease the search space.
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
            }

            if (mid < arr.length - 1 && arr[mid] < arr[mid - 1]) {
                start = mid;
                break;
            } else if (arr[mid] <= arr[end]) {
                // if right half is sorted, move left
                end = mid - 1;
            } else {
                // if left half is sorted, move right
                start = mid + 1;
            }
        }

        return start;
    }

    static void maxElement(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + ((end - start) / 2);

            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                end = mid;
                break;
            } else if (arr[mid] <= arr[end]) {
                // if right half is sorted, move left
                end = mid - 1;
            } else {
                // if left half is sorted, move right
                start = mid + 1;
            }
        }

        System.out.print("Maximum element is " + arr[end] + " at index " + end + " in ");
        printArray(arr);
    }

    static void clockWiseRotationCount(int arr[]) {
        // Index of minimum element is the clockwise rotation count.
        int index = minElementEdgeCase(arr);

        System.out.print(index + " is the Clockwise Rotation Count of ");
        printArray(arr);
    }
    
    static void anticlockWiseRotationCount(int arr[]) {
        // Index of minimum element is the clockwise rotation count.
        int index = minElementEdgeCase(arr);

        System.out.print(((arr.length - index) % arr.length) + " is the Anti-Clockwise Rotation Count of ");
        printArray(arr);
    }
    
    static void searchElement(int arr[], int target) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == target) {
                ans = mid;
            }

            if (arr[mid] < arr[end]) {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        if (ans != -1) {
            System.out.print(target + " is found at index " + ans + " in ");
            printArray(arr);
        } else {
            System.out.print(target + " was not found in ");
            printArray(arr);
        }
    }
}
