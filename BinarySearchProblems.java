public class BinarySearchProblems {
    public static void main(String[] args) {
        int arr[] = { 12, 34, 67, 90 };
        minimumNumberOfPagesAllocation(arr, 2);
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
}
