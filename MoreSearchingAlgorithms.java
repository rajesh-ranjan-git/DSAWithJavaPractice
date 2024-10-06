public class MoreSearchingAlgorithms {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 5, 7, 10, 16, 19, 24, 30 };
        // jumpSearch(nums, 2);
        // ternarySearch(nums, 10);
        exponentialSearch(nums, 1);
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
        if (nums[0] == target) {
            System.out.println("Element found at : " + 0);
            return;
        }
        
        int i = 1;

        while (i < nums.length && nums[i] <= target) {
            i *= 2;
        }

        int start = i / 2;
        int end = Math.min(i, nums.length - 1);

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
}
