package leetcode;

import java.util.Arrays;

public class FindFirstAndLasPosition {

    public int[] searchRange(int[] nums, int target) {
        return binSearch(nums, 0, nums.length - 1, target);
    }

    private int[] binSearch(int[] nums, int start, int end, int target) {
        if (start > end || start < 0 || end >= nums.length) {
            return new int[]{-1, -1};
        }
        int m = (start + end) / 2;
        if (nums[m] == target) {
            //find most left
            int[] leftIndex = binSearch(nums, start, m - 1, target);
            //find most right
            int[] rightIndex = binSearch(nums, m + 1, end, target);
            int left = leftIndex[0], right = rightIndex[1];
            left = left == -1 ? m : left;
            right = right == -1 ? m : right;
            return new int[]{left, right};
        } else if (target < nums[m]) {
            return binSearch(nums, start, m - 1, target);
        } else {
            return binSearch(nums, m + 1, end, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new FindFirstAndLasPosition().searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
}
