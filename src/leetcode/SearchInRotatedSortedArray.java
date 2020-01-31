package leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        //没有旋转
        if (nums[nums.length - 1] >= nums[0]) {
            return binSearch(nums, 0, nums.length - 1, target);
        }
        //二分法找到支点，最终结果为nums[pivot] > nums[pivot+1]
        int start = 0, end = nums.length - 1;
        int pivot = 0;
        while (start <= end) {
            if (nums[start] > nums[start + 1]) {
                pivot = start;
                break;
            }
            int m = (start + end) / 2;
            if (nums[m] > nums[0]) {
                start = m;
            } else if (nums[m] <= nums[0]) {
                end = m;
            }
        }
        if (target == nums[0]) {
            return 0;
        } else if (target < nums[0]) {
            return binSearch(nums, pivot + 1, nums.length - 1, target);
        } else {
            return binSearch(nums, 1, pivot, target);
        }
    }

    private int binSearch(int[] nums, int start, int end, int target) {
        if (start > end || end >= nums.length || start < 0) {
            return -1;
        }
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int m = (start + end) / 2;
        if (target < nums[m]) {
            return binSearch(nums, start, m - 1, target);
        } else if (nums[m] == target) {
            return m;
        } else {
            return binSearch(nums, m + 1, end, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{3, 5, 1}, 3));
    }
}
