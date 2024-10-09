import java.util.Arrays;

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
        // int[] quantities = { 15, 10, 10 };
        // minimizedMaximum_2064(7, quantities);

        // int[] stalls = { 1, 2, 4, 8, 9 };
        // aggressiveCows(stalls, 5, 3);

        // int[] nums1 = { 1, 2 };
        // int[] nums2 = { 3, 4 };
        // findMedianSortedArrays_4(nums1, nums2);

        // int[] nums1 = { 2, 3, 6, 7, 9 };
        // int[] nums2 = { 1, 4, 8, 10 };
        // kthElementInSortedArray(nums1, nums2, 5);

        // int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        // singleElementInSortedArray(nums);

        // sqrt_69(146);

        noOfPerfectSquares(9);
    }
    
    static void minimumNumberOfPagesAllocation(int books[], int students) {
        // Each student will be allocated at least 1 book.
        if (books.length < students) {
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

    static void aggressiveCows(int[] stalls, int positionOfStalls, int noOfCows) {
        // If not enough stalls, then return
        if (stalls.length < noOfCows) {
            System.out.println("Cows arrangement is not possible as no. of cows exceeds number of stalls.");
            return;
        }

        // Sort your arrays.
        Arrays.sort(stalls);

        int start = 1;
        int end = stalls[positionOfStalls - 1] - stalls[0];
        int maximumDifference = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isArrangementPossible(stalls, mid, noOfCows)) {
                maximumDifference = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println("Maximum difference is : " + maximumDifference);
    }
    
    static boolean isArrangementPossible(int stalls[], int minDistance, int noOfCows) {
        int cowsCount = 1;
        int lastCowDist = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            // Check if minimum distance obtained is maintained then increase count of cows and assign new location.
            if (stalls[i] - lastCowDist >= minDistance) {
                cowsCount++;
                lastCowDist = stalls[i];
            }

            if (cowsCount >= noOfCows) {
                return true;
            }
        }

        return false;
    }

    // static void findMedianSortedArrays_4(int[] nums1, int[] nums2) {
    //     int[] nums3 = new int[nums1.length + nums2.length];

    //     for (int i = 0; i < nums1.length; i++) {
    //         nums3[i] = nums1[i];
    //     }

    //     int j = 0;
    //     for (int i = nums1.length; i < nums3.length; i++) {
    //         nums3[i] = nums2[j];
    //         j++;
    //     }

    //     printArray(nums3);

    //     Arrays.sort(nums3);

    //     printArray(nums3);

    //     if (nums3.length % 2 == 0) {
    //         System.out.println("nums3 length is even : " + nums3.length);
    //         System.out.println(
    //                 "((N/2 - 1) + N/2)/2 : " + ((nums3[((nums3.length / 2) - 1)] + nums3[(nums3.length / 2)]) / 2));
    //     } else {
    //         System.out.println("nums3 length is even");
    //         System.out.println("nums3.length / 2" + (nums3[nums3.length / 2]));
    //     }
    // }
    
    static void findMedianSortedArrays_4(int[] nums1, int[] nums2) {
        // Make num1 as min length array
        // Call same function and swap the params (recursion)
        // if nums1 was greater and nums2 was smaller and we swapped them, now nums1 is smaller and num2 is greater.
        if (nums1.length > nums2.length) {
            findMedianSortedArrays_4(nums2, nums1);
            return;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int N = n1 + n2;
        int start = 0;
        int end = n1;

        while (start <= end) {
            int cut1 = start + ((end - start) / 2); // mid
            int cut2 = N / 2 - cut1; // (n1 + n2)/2 - length of cut1

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Check if cut is valid
            if (l1 <= r2 && l2 <= r1) {
                // N is even or odd
                if (N % 2 == 0) {
                    System.out.println((((l1 > l2 ? l1 : l2) + (r1 > r2 ? r2 : r1)) / 2.0)); // Two medians, so take mean (avg) of medians
                } else {
                    System.out.println((double) (r1 > r2 ? r2 : r1));
                }
            }
            if (l1 > r2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }
        }
    }

    static void kthElementInSortedArray(int[] nums1, int[] nums2, int k) {
        // Make num1 as min length array
        // Call same function and change swap the params (recursion)
        // if nums1 was greater and nums2 was smaller and we swapped them, now nums1 is smaller and num2 is greater.
        if (nums1.length > nums2.length) {
            findMedianSortedArrays_4(nums2, nums1);
            return;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int start = Math.max(0, k - n2);
        int end = Math.min(k, n1);

        while (start <= end) {
            int cut1 = start + ((end - start) / 2); // mid
            int cut2 = k - cut1; // k - length of cut1

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Check if cut is valid
            if (l1 <= r2 && l2 <= r1) {
                System.out.println(Math.max(l1, l2));
            }
            if (l1 > r2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }
        }
    }

    static void singleElementInSortedArray(int[] nums) {
        int start = 0;
        int end = nums.length - 2;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (nums[mid] == nums[mid ^ 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // while (start < end) {
        //     int mid = start + ((end - start) / 2);

        //     if ((mid % 2 == 0) && (nums[mid] == nums[mid - 1])) {
        //         end = mid - 1;
        //     } else if ((mid % 2 == 0) && (nums[mid] == nums[mid + 1])) {
        //         start = mid + 1;
        //     } else if ((mid % 2 != 0) && (nums[mid] == nums[mid - 1])) {
        //         start = mid + 1;
        //     } else if ((mid % 2 != 0) && (nums[mid] == nums[mid + 1])) {
        //         end = mid - 1;
        //     }
        // }

        System.out.println(nums[start]);
    }

    static void sqrt_69(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid <= num / mid) {
                if (num % mid == 0 && mid == num / mid) {
                    System.out.println(mid);
                    return;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }

    static void noOfPerfectSquares(int num) {
        int start = 1;
        int end = num;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid <= num / mid) {
                if (num % mid == 0 && mid == num / mid) {
                    res = mid;
                    break;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (res != -1) {
            System.out.println(res - 1);
        } else {
            System.out.println(start - 1);
        }
        
    }
}
