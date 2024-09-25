
import java.util.Scanner;

public class MyArrays {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int arr[] = new int[8];
        // System.out.print("Initially array elements are prefilled with 0s.\nInitial array : ");
        // printArray(arr);
        // takeArrayInput(arr);
        // printArray(arr);
        // insertIntoArray(arr, 3, 9);
        // printArray(arr);
        // deleteFromArray(arr, 3);
        // printArray(arr);
        // updateArray(arr, 3, 10);
        // printArray(arr);

        int arr2D[][] = new int[4][3];
        System.out.print("Initially array elements are prefilled with 0s.\nInitial array : ");
        printArray2D(arr2D);
        takeArrayInput2D(arr2D);
        printArray2D(arr2D);
        // insertIntoArray2D(arr2D, 3, 9);
        // printArray2D(arr);
        // deleteFromArray2D(arr2D, 3);
        // printArray2D(arr2D);
        // updateArray2D(arr2D, 3, 10);
        // printArray2D(arr2D);
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

    static void takeArrayInput(int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter array element at " + (i + 1) + " : ");
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    static void insertIntoArray(int arr[], int pos, int ele) {
        for (int i = arr.length - 2; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = ele;
    }

    static void deleteFromArray(int arr[], int pos) {
        for (int i = pos; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    static void updateArray(int arr[], int pos, int ele) {
        arr[pos] = ele;
    }

    static void printArray2D(int arr[][]) {
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

    static void takeArrayInput2D(int arr[][]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Enter array element at " + i + "" + j + " : ");
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }
}
