import java.util.ArrayList;
import java.util.List;

public class SortingAlogProblems {
    public static void main(String[] args) {
        // int[] arr = { 3, 0, 1 };
        // int[] arr = { 0, 1 };
        // int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        // int[] arr = { 1, 3, 4, 2, 2 };

        // missingNumber_268(arr); // Time Complexity : O(N)
        // findDisappearedNumbers_448(arr); // Time Complexity : O(N)
        // findDuplicateNumber_287(arr);
        // findAllDuplicates_442(arr);
        // findDuplicateNumber_287_Better(arr);
        findAllDuplicateNumber_442_Better(arr);
    }

    static void missingNumber_268(int[] arr) {
        int sum = arr.length * (arr.length + 1) / 2;
        int actualSum = 0;

        // Sum of array
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        System.out.println("Missing number is : " + (sum - actualSum));
    }

    static void findDisappearedNumbers_448(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        cycleSort1ToN(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                list.add(i + 1);
            }
        }

        System.out.println(list);
    }

    static void findDuplicateNumber_287(int[] arr) {
        cycleSort1ToN(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                System.out.println(arr[i]);
            }
        }
    }

    static void findAllDuplicates_442(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        cycleSort1ToN(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                list.add(arr[i]);
            }
        }

        System.out.println(list);
    }

    static void cycleSort1ToN(int[] arr) {
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            int actualPos = element - 1;
            if (arr[index] != arr[actualPos]) {
                swap(arr, index, actualPos);
            } else {
                index++;
            }
        }
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void findDuplicateNumber_287_Better(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int element = Math.abs(arr[i]);
            int actualIdx = element - 1;

            if (arr[actualIdx] < 0) {
                System.out.println(element);
                break;
            }
            arr[actualIdx] = -1 * arr[actualIdx];
        }
    }

    static void findAllDuplicateNumber_442_Better(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int element = Math.abs(arr[i]);
            int actualIdx = element - 1;

            if (arr[actualIdx] < 0) {
                count++;
                list.add(element);
            } else { // If count is needed
                arr[actualIdx] = -1 * arr[actualIdx];
            }
            // arr[actualIdx] = -1 * arr[actualIdx]; // If count is not needed
        }

        System.out.println(list);
        System.out.println(count);
    }
}
