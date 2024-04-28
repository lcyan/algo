package cn.vvspace.algo.repeat.binarysearch;

/**
 * <a href=""></a>
 */
public class Solution001 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 2, 9, 20};
        System.out.println(new Solution001().binarySearch(nums, 5));

        int[] nums1 = new int[]{1, 2, 2, 2, 4};
        System.out.println(new Solution001().right_bound(nums1, 6));
    }

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) { // left + 1 = right
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                left = mid + 1;
            } else if (cur > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) { // => [left = right, right]
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                right = mid; // mid = right;
            } else if (cur < target) {
                left = mid + 1;
            } else if (cur > target) {
                right = mid;
            }
        }

        // return left;
        // return right;
        if (left < 0 || left >= nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    int left_bound_v1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { // [left = right+1, right]
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                right = mid - 1; // mid = right + 1;
            } else if (cur < target) {
                left = mid + 1;
            } else if (cur > target) {
                right = mid - 1;
            }
        }

        // => return left;
        // => return right + 1;
        if (left < 0 || left >= nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) { // => [right, right]
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                left = mid + 1; // => mid = left - 1;
            } else if (cur < target) {
                left = mid + 1;
            } else if (cur > target) {
                right = mid;
            }
        }

        // => return left - 1;
        // => return right - 1;

        if (left - 1 < 0 || left - 1 >= nums.length) {
            return -1;
        }

        return nums[left - 1] == target ? (left - 1) : -1;
    }

    int right_bound_v1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { // => [left = right + 1; right]
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                left = mid + 1; // => mid = left -1;
            } else if (cur < target) {
                left = mid + 1;
            } else if (cur > target) {
                right = mid - 1;
            }


        }
        // => return left -1;
        // =>return right;
        if (left - 1 < 0 || left - 1 > nums.length) {
            return -1;
        }
        return nums[left - 1] == target ? (left - 1) : -1;
    }
}
