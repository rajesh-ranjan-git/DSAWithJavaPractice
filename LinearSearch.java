public class LinearSearch {
    public static void main(String[] args) {
        // int arr[] = { 54, 8, 54, 98, 45, 68, 98, 52, 98 };
        // printArray(arr);
        // firstOccurrence(arr, 98);
        // int countOfOccurrence = findAllOccurrence(arr, 98);
        // System.out.print("98 occurred " + countOfOccurrence + " times in ");
        // printArray(arr);
        // findLastOccurrence(arr, 98);
        // checkElementPresence(arr, 98);
        // findMinMaxArr(arr);

        int arr2d[][] = {
                { 2, 4, 1, 5, 1 },
                { 6, 7, 3, 4, 2 },
                { 8, 1, 2, 2, 3 },
                { 5, 5, 5, 8, 4 }
        };
        printArray2d(arr2d);
        firstOccurrence2d(arr2d, 3);
        int countOfOccurrence2d = findAllOccurrence2d(arr2d, 3);
        System.out.print("3 occurred " + countOfOccurrence2d + " times in ");
        printArray2d(arr2d);
        findLastOccurrence2d(arr2d, 3);
        checkElementPresence2d(arr2d, 3);
        findMinMaxArr2d(arr2d);
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

    static void firstOccurrence(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println(i + " is first occurrence of " + target + ".");
                break;
            }
        }
    }

    static int findAllOccurrence(int arr[], int target) {
        int countOfOccurrence = 0;
        System.out.print(target + " is present at : ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (countOfOccurrence == 0) {
                    System.out.print(i);
                } else {
                    System.out.print(", " + i);
                }
                countOfOccurrence++;
            }
        }
        System.out.println();
        return countOfOccurrence;
    }

    static void findLastOccurrence(int arr[], int target) {
        int lastPos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                lastPos = i;
            }
        }
        System.out.println(lastPos + " is the last occurrence position of " + target + ".");
    }

    static void checkElementPresence(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.print(target + " is present in ");
                printArray(arr);
                return;
            }
        }
        System.out.print(target + " is not present in ");
        printArray(arr);
    }

    static void findMinMaxArr(int arr[]) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.print("Minimum value is " + min + " and Maximum value is " + max + " in ");
        printArray(arr);
    }

    static void printArray2d(int arr[][]) {
        System.out.print("arr : [");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[");
            } else {
                System.out.print(", [");
            }
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j != arr[i].length - 1) {
                    System.out.print(", ");
                } else {
                    System.out.print("]");
                }
            }
            if (i == arr.length - 1) {
                System.out.print("]");
            }
        }
        System.out.println();
    }

    static void firstOccurrence2d(int arr[][], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    System.out.println(i+ "" + j + " is first occurrence of " + target + ".");
                    break;
                }
            }
        }
    }

    static int findAllOccurrence2d(int arr[][], int target) {
        int countOfOccurrence = 0;
        System.out.print(target + " is present at : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    if (countOfOccurrence == 0) {
                        System.out.print(i + "" + j);
                    } else {
                        System.out.print(", " + i + "" + j);
                    }
                    countOfOccurrence++;
                }
            }
        }
        System.out.println();
        return countOfOccurrence;
    }

    static void findLastOccurrence2d(int arr[][], int target) {
        String lastPos = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    lastPos = i + "" + j;
                }
            }
        }
        System.out.println(lastPos + " is the last occurrence position of " + target + ".");
    }

    static void checkElementPresence2d(int arr[][], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    System.out.print(target + " is present in ");
                    printArray2d(arr);
                    return;
                }
            }
        }
        System.out.print(target + " is not present in ");
        printArray2d(arr);
    }

    static void findMinMaxArr2d(int arr[][]) {
        int max = arr[0][0];
        int min = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
            if (max < arr[i][j]) {
                max = arr[i][j];
            }
            if (min > arr[i][j]) {
                min = arr[i][j];
            }
        }
        }
        System.out.print("Minimum value is " + min + " and Maximum value is " + max + " in ");
        printArray2d(arr);
    }
}
