public class BinarySearchProblems_1011 {
    public static void main(String[] args) {
        int books[] = { 12, 34, 67, 90 };
        minimumNumberOfPagesAllocation(books, 2);

        int weights[] = { 3, 2, 2, 4, 1, 4 };
        shipWithinDays(weights, 3);
    }
    
    static void minimumNumberOfPagesAllocation(int books[], int students) {
        // Each student will be allocated at least 1 book.
        if (students >= books.length) {
            System.out.println("Allocation of books is not possible.");
            return;
        }

        // Range will be max of array and sum of array.
        int start = Integer.MIN_VALUE;
        int end = 0; // Sum of array.

        for (int i = 0; i < books.length; i++) {
            if (start < books[i]) {
                start = books[i];
            }

            end += books[i];
        }

        int res = -1;

        while (start <= end) {
            // Max pages that can be allocated to single student.
            int mid = start + (end - start) / 2;

            // If allocation is possible then minimize the number of pages.
            if (isAllocationPossible(books, mid, students)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("Answer : " + res);
    }

    static boolean isAllocationPossible(int books[], int maxPages, int students) {
        int currentStudent = 1;
        int pages = 0;

        for (int i = 0; i < books.length; i++) {
            pages += books[i];

            // If pages exceed maxPages.
            if (pages > maxPages) {
                // Allocate to next student.
                currentStudent++;
                pages = books[i];
            }

            if (currentStudent > students) {
                return false;
            }
        }

        return true;
    }

    static void shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE;
        int end = 0;

        for (int i = 0; i < weights.length; i++) {
            if (start < weights[i]) {
                start = weights[i];
            }

            end += weights[i];
        }

        int res = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (isShipmentPossible(weights, mid, days)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (res == -1) {
            System.out.println("No possible minimum value found.");
        } else {
            System.out.println("Minimum weight capacity : " + res);
        }
    }
    
    static boolean isShipmentPossible(int[] weights, int maxWeight, int days) {
        int dayCounter = 1;
        int sumOfWeight = 0;
        
        for (int i = 0; i < weights.length; i++) {
            sumOfWeight += weights[i];

            if (sumOfWeight > maxWeight) {
                dayCounter++;
                sumOfWeight = weights[i];
            }
        }

        if (dayCounter > days) {
            return false;
        }

        return true;
    }
}
