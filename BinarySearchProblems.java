public class BinarySearchProblems {
    public static void main(String[] args) {
        // int books[] = { 12, 34, 67, 90 };
        // minimumNumberOfPagesAllocation(books, 2);

        // int weights[] = { 3, 2, 2, 4, 1, 4 };
        // shipWithinDays_1011(weights, 3);

        // int[] piles = { 3, 6, 7, 11 };
        // int[] piles = { 30, 11, 23, 4, 20 };
        // int[] piles = { 805306368, 805306368, 805306368 };
        // minEatingSpeed_875(piles, 8);

        // int[] nums = { 1, 2, 5, 9 }; // k = 5
        // int[] nums = { 44, 22, 33, 11, 1 }; // k = 44
        // smallestDivisor_1283(nums, 5);

        // int[] quantities = { 11, 6 };
        int[] quantities = { 15, 10, 10 };
        minimizedMaximum_2064(7, quantities);
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

    static void shipWithinDays_1011(int[] weights, int days) {
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
    
    static void minEatingSpeed_875(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        int res = -1;

        //Finding max
        for (int i = 0; i < piles.length; i++) {
            if (end < piles[i]) {
                end = piles[i];
            }
        }

        // Apply binary search on the possible values of K -> (1, max(piles))
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isEatingPossible(piles, mid, h)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("Minimum banana to eat in 1 hr : " + res);
    }

    static boolean isEatingPossible(int[] piles, int maxEatingCapacity, int h) {
        long requiredHours = 0;

        for (int i = 0; i < piles.length; i++) {
            requiredHours += piles[i] / maxEatingCapacity;

            if (piles[i] % maxEatingCapacity != 0) {
                requiredHours++;
            }
        }

        if (requiredHours > h) {
            return false;
        }

        return true;
    }
    
    static void smallestDivisor_1283(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        int res = -1;

        // Find maximum divisor that can divide all the elements in array.
        for (int i = 0; i < nums.length; i++) {
            if (end < nums[i]) {
                end = nums[i];
            }
        }

        // Apply binary search on the given range.
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (possibleDivisorResultSum(nums, mid) <= threshold) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(res);
    }

    static int possibleDivisorResultSum(int[] nums, int divisor) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] / divisor);

            if (nums[i] % divisor != 0) {
                sum++;
            }
        }

        return sum;
    }

    static void minimizedMaximum_2064(int n, int[] quantities) {
        int start = 1; // To avoid zero division error.
        int end = Integer.MIN_VALUE; // To find maximum value
        int res = -1;

        for (int i = 0; i < quantities.length; i++) {
            if (end < quantities[i]) {
                end = quantities[i];
            }
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isDistributionPossible(quantities, mid, n)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(res);
    }

    static boolean isDistributionPossible(int[] quantities, int maxProducts, int stores) {
        int storeCount = 0;

        for (int i = 0; i < quantities.length; i++) {
            storeCount += quantities[i] / maxProducts;

            if (quantities[i] % maxProducts != 0) {
                storeCount++;
            }

            if (storeCount > stores) {
                return false;
            }
        }

        return true;
    }
}
