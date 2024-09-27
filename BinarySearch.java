public class BinarySearch {
    public static void main(String[] args) {
        int arr1[] = { 2, 5, 7, 11, 13, 45, 87, 90, 91, 92, 93, 94 };
        int arr2[] = { 90, 87, 54, 36, 22, 1 };
        binarySearchOrderAgnostic(arr1, 87);
        binarySearchOrderAgnostic(arr2, 54);

        int arr3[] = { 2, 5, 7, 11, 45, 45, 45, 45, 87, 90 };
        int arr4[] = { 90, 87, 54, 54, 54, 36, 22, 1 };
        int first = firstLastOccurrence(arr3, 45, true);
        int last = firstLastOccurrence(arr3, 45, false);
        firstLastOccurrence(arr4, 54, true);
        firstLastOccurrence(arr4, 54, false);
        firstLastOccurrence(arr4, 56, false);

        if (first == -1 || last == -1) {
            System.out.println("45 occurred 0 times.");
        } else {
            System.out.println("45 occurred " + (last - first + 1) + " times.");
        }

        floorValue(arr1, 1);
        floorValue(arr2, 17);
        ceilValue(arr1, 94);
        ceilValue(arr2, 17);

        char chArr1[] = { 'c', 'f', 'j' };
        nextGreatestCharacter(chArr1, 'c');
        char chArr2[] = { 'j', 'f', 'c' };
        nextGreatestCharacter(chArr2, 'c');

        minAbsoluteDiff(arr1, 0);

        binarySearchInfiniteArray(arr1, 45);

        int arr5[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, };
        findFirstOccurrenceInBinarySortedArray(arr5, 1);
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
    
    static void binarySearchOrderAgnostic(int arr[], int target) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int ans = -1;

        if (arr[0] <= arr[arr.length - 1]) {
            ans = binarySearchAscending(arr, target);
        } else {
            ans = binarySearchDescending(arr, target);
        }

        if (ans == -1) {
            System.out.print(target + " is not present in ");
        } else {
            System.out.print(target + " is present at " + ans + " in ");
        }
        printArray(arr);
    }
    
    static int firstLastOccurrenceAscending(int arr[], int target, boolean isFirst) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                ans = mid;
                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    static int firstLastOccurrenceDescending(int arr[], int target, boolean isFirst) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                ans = mid;
                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    static int firstLastOccurrence(int arr[], int target, boolean isFirst) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return 0;
        }

        int ans = -1;

        if (arr[0] <= arr[arr.length - 1]) {
            ans = firstLastOccurrenceAscending(arr, target, isFirst);
        } else {
            ans = firstLastOccurrenceDescending(arr, target, isFirst);
        }

        if (ans == -1) {
            System.out.print(target + " is not present in ");
        } else {
            if (isFirst) {
                System.out.print("First occurrence of " + target + " is at position " + ans + " in ");
            } else {
                System.out.print("Last occurrence of " + target + " is at position " + ans + " in ");
            }
        }
        printArray(arr);
        return ans;
    }

    static int floorValueAscending(int arr[], int target) {
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
                ans = mid;
            }
        }

        return ans;
    }
    
    static int floorValueDescending( int arr[], int target) {
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
                ans = mid;
            }
        }

        return ans;
    }

    static void floorValue(int arr[], int target) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int ans = -1;

        if (arr[0] <= arr[arr.length - 1]) {
            ans = floorValueAscending(arr, target);
        } else {
            ans = floorValueDescending(arr, target);
        }

        if (ans == -1) {
            System.out.print("No Floor value of " + target + " was found in ");
        } else {
            System.out.print("Floor value of " + target + " is " + arr[ans] + " at position " + ans + " in ");
        }
        printArray(arr);
    }
    
    static int ceilValueAscending(int arr[], int target) {
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
                ans = mid;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    
    static int ceilValueDescending( int arr[], int target) {
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
                ans = mid;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    static void ceilValue(int arr[], int target) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int ans = -1;

        if (arr[0] <= arr[arr.length - 1]) {
            ans = ceilValueAscending(arr, target);
        } else {
            ans = ceilValueDescending(arr, target);
        }

        if (ans == -1) {
            System.out.print("No Ceiling value of " + target + " was found in ");
        } else {
            System.out.print("Ceiling value of " + target + " is " + arr[ans] + " at position " + ans + " in ");
        }
        printArray(arr);
    }
    
    static int nextGreatestCharAscending(char arr[], char target) {
        int ans = '$';
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }
    
    static int nextGreatestCharDescending( char arr[], char target) {
        int ans = '$';
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] <= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }

    static void nextGreatestCharacter(char arr[], char target) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int ans = '$';

        if (arr[0] <= arr[arr.length - 1]) {
            ans = nextGreatestCharAscending(arr, target);
        } else {
            ans = nextGreatestCharDescending(arr, target);
        }

        if (ans == '$') {
            System.out.print("No Ceiling value of " + target + " was found so answer is " + arr[0] + " in ");
        } else {
            System.out.print("Ceiling value of " + target + " is " + arr[ans] + " at position " + ans + " in ");
        }
        printCharArray(arr);
    }
    
    static void printCharArray(char arr[]) {
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

    static void minAbsoluteDiff(int arr[], int target) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

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

        if (ans == -1) {
            if (end == -1) {
                System.out.println("Minimum Absolute difference is : " + (int) Math.abs(target - arr[start]));
            } else if (start == arr.length) {
                System.out.println("Minimum Absolute difference is : " + (int) Math.abs(target - arr[end]));
            } else {
                int ansFloor = (int) Math.abs(target - arr[end]);
                int ansCeil = (int) Math.abs(target - arr[start]);
                System.out.println("New ansFloor : " + ansFloor + " New ansCeil : " + ansCeil);
                int newAns = (ansFloor > ansCeil) ? ansCeil : ansFloor;
                System.out.println("Minimum Absolute difference is : " + newAns);
            }
        } else {
            System.out.println("Minimum Absolute difference is : " + 0);
        }
    }

    static int binarySearchAscendingInRange(int arr[], int start, int end, int target) {
        int ans = -1;

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

    static int[] findRangeForBinarySearch(int arr[], int start, int end, int target) {
        while (target > arr[end]) {
            start = end;
            end *= 2;
        }

        int range[] = new int[2];
        range[0] = start;
        range[1] = end;

        return range;
    }
    
    static void binarySearchInfiniteArray(int arr[], int target) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int range[] = findRangeForBinarySearch(arr, 0, 1, target);
        System.out.println("Range : " + range[0] + " and " + range[1]);

        int ans = binarySearchAscendingInRange(arr, range[0], range[1], target);

        if (ans == -1) {
            System.out.print(target + " is not present in ");
        } else {
            System.out.print(target + " is present at index " + ans + " in ");
        }
        printArray(arr);
    }

    static int firstOccurrenceAscending(int arr[], int start, int end, int target) {
        int ans = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    
    static void findFirstOccurrenceInBinarySortedArray(int arr[], int target) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        
        int range[] = findRangeForBinarySearch(arr, 0, 1, target);
        System.out.println("Range : " + range[0] + " and " + range[1]);

        int ans = firstOccurrenceAscending(arr, range[0], range[1], target);

        if (ans == -1) {
            System.out.print(target + " is not present in ");
        } else {
            System.out.print("First occurrence of " + target + " is at index " + ans + " in ");
        }
        printArray(arr);
    }
}
