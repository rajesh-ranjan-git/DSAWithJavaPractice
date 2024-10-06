public class MatrixProblems {
    public static void main(String[] args) {
        // int nums[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
        // medianOfRowWiseSortedMatrix(nums, 3, 3);

        // int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        // int[][] matrix = { { -5 } };
        // int[][] matrix = { { 1, 2 }, { 1, 3 } };
        // kthSmallestElementInSortedMatrix_378(matrix, 4);

        // int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        // search2DMatrix_74(matrix, 0);

        // int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
        //         { 18, 21, 23, 26, 30 } };
        // search2DMatrix2_240(matrix, 24);

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // transpose(matrix);
        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        // transpose_867(matrix);
        // rotateMatrixClockWise_48(matrix);
        rotateMatrixAntiClockWise(matrix);
    }

    static void medianOfRowWiseSortedMatrix(int[][] nums, int R, int C) {
        int start = 1;
        int end = 2000;
        int N = R * C;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int k = findNoOfSmallerElements(nums, mid);

            if (k <= N / 2) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
    
    static int findNoOfSmallerElements(int[][] nums, int target) {
        int noOfSmallerElements = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            int end = nums[i].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (nums[i][mid] <= target) {
                    start = mid + 1;
                } else if (nums[i][mid] > target) {
                    end = mid - 1;
                }
            }

            noOfSmallerElements += start;
        }

        return noOfSmallerElements;
    }
    
    static void kthSmallestElementInSortedMatrix_378(int[][] matrix, int k) {
        int start = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix[0].length - 1];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int noOfSmallerElements = findNoOfSmallerElements(matrix, mid);

            if (noOfSmallerElements <= k - 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

    static void search2DMatrix_74(int[][] matrix, int target) {
        // Time complexity O(mlogn)
        // for (int i = 0; i < matrix.length; i++) {
        //     if (target <= matrix[i][matrix[i].length - 1]) {
        //         int start = 0;
        //         int end = matrix[i].length - 1;

        //         while (start <= end) {
        //             int mid = start + (end - start) / 2;

        //             if (matrix[i][mid] == target) {
        //                 System.out.println("Element is present at : " + i + "" + mid);
        //                 return;
        //             } else if (matrix[i][mid] <= target) {
        //                 start = mid + 1;
        //             } else {
        //                 end = mid - 1;
        //             }
        //         }
        //     }
        // }

        // Efficient method with time complexity of O(logm*n)
        if (matrix.length == 0) {
            System.out.println("Element is not present");
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int r = mid / n;
            int c = mid % n;
            int val = matrix[r][c];

            if (val == target) {
                System.out.println("Element is present");
                return;
            } else if (val < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println("Element is not present");
    }

    static void search2DMatrix2_240(int[][] matrix, int target) {
        // for (int i = 0; i < matrix.length; i++) {
        //     if (target <= matrix[i][matrix[i].length - 1]) {
        //         int start = 0;
        //         int end = matrix[i].length - 1;

        //         while (start <= end) {
        //             int mid = start + (end - start) / 2;

        //             if (matrix[i][mid] == target) {
        //                 System.out.println("Element is present at : " + i + "" + mid);
        //                 return;
        //             } else if (matrix[i][mid] <= target) {
        //                 start = mid + 1;
        //             } else {
        //                 end = mid - 1;
        //             }
        //         }
        //     }
        // }

        if (matrix.length == 0) {
            System.out.println("Element is not present");
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;

        while (rows > r && c >= 0) {
            if (matrix[r][c] == target) {
                System.out.println("Element is present");
                return;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        System.out.println("Element is not present");
    }

    static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j);
            }
        }
    }

    static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    static void transpose_867(int[][] matrix) {
        int[][] a = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = matrix[j][i];
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    static void rotateMatrixClockWise_48(int[][] matrix) {
        transpose(matrix);

        // Reverse rows
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    static void rotateMatrixAntiClockWise(int[][] matrix) {
        transpose(matrix);

        // Reverse rows
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
    }
}
