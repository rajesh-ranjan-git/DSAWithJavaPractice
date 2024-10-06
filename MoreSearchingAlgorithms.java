public class MoreSearchingAlgorithms {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 5, 7, 10, 16, 19, 24, 30 };
        // jumpSearch(nums, 2);
        // ternarySearch(nums, 10);
        // exponentialSearch(nums, 1);
        interpolationSearch(nums, 100);
    }

    static void jumpSearch(int[] nums, int target) {
        int blockSize = (int) Math.sqrt(nums.length);
        int start = 0;
        int end = blockSize;

        // Jump non-potential blocks
        while (end < nums.length && nums[end] <= target) {
            start = end;
            end += blockSize;

            if (end > nums.length) {
                end = nums.length;
            }
        }

        // Apply linear search in the range found above
        for (int i = start; i < end; i++) {
            if (nums[i] == target) {
                System.out.println("Element found at : " + i);
                return;
            }
        }

        System.out.println("Element not found.");
    }
    
    static void ternarySearch(int[] nums, int target) {
        // Time complexity of this search is log3(N) which a bit faster than Binary search where it is log2(N)
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid1 = start + (end - start) / 3;
            int mid2 = end - (end - start) / 3;

            if (target <= nums[mid1]) {
                if (target == nums[mid1]) {
                    System.out.println("Element found at : " + mid1);
                    return;
                }
                end = mid1 - 1;
            } else if (target >= nums[mid2]) {
                if (target == nums[mid2]) {
                    System.out.println("Element found at : " + mid2);
                    return;
                }
                start = mid2 + 1;
            } else {
                start = mid1 = 1;
                end = mid2 - 1;
            }
        }
        System.out.println("Element not found");
    }

    static void exponentialSearch(int[] nums, int target) {
        // This is similar to infinite array search
        if (nums[0] == target) {
            System.out.println("Element found at : " + 0);
            return;
        }

        int i = 1;

        // Skip search spaces
        while (i < nums.length && nums[i] <= target) {
            i *= 2;
        }

        int start = i / 2;
        int end = Math.min(i, nums.length - 1);

        // Apply ternary search in range
        while (start <= end) {
            int mid1 = start + (end - start) / 3;
            int mid2 = end - (end - start) / 3;

            if (target <= nums[mid1]) {
                if (target == nums[mid1]) {
                    System.out.println("Element found at : " + mid1);
                    return;
                }
                end = mid1 - 1;
            } else if (target >= nums[mid2]) {
                if (target == nums[mid2]) {
                    System.out.println("Element found at : " + mid2);
                    return;
                }
                start = mid2 + 1;
            } else {
                start = mid1 = 1;
                end = mid2 - 1;
            }
        }
        System.out.println("Element not found");
    }
    
    static void interpolationSearch(int[] nums, int target) {
        // This search has pre-requisite that the array is sorted, and has unique elements.
        // Try to apply this only when data has same difference between elements (uniform) -> it will give the answer in one shot
        // It will take more time when data is not uniform so not recommended with non-uniform data.

        // Formula for Interpolation Search
        // lo + (target - arr[lo]) * ((hi - lo) / (arr[hi] - arr[lo]))
        // where lo = starting index of sorted array
        // hi = ending index of sorted array

        // Time complexity of this search is log2(log2N)

        int start = 0;
        int end = nums.length - 1;

        // Apply ternary search and the condition is to avoid ArrayIndexOutOfBounds Exception
        while (start <= end && target >= nums[start] && target <= nums[end]) {
            if (nums[start] == nums[end]) {
                if (nums[start] == target) {
                    System.out.println("Element found at : " + start);
                    return;
                }
            }
            
            int pos = start + (target - nums[start]) * ((end - start) / (nums[end] - nums[start]));

            if (nums[pos] == target) {
                System.out.println("Element found at : " + pos);
                return;
            } else if (nums[pos] > target) {
                end = pos - 1;
            } else {
                start = pos + 1;
            }
        }

        System.out.println("Element not found");
    }
}
