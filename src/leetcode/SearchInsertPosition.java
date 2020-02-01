package leetcode;

/**
 * leetcode: https://leetcode.com/problems/search-insert-position/
 * result: success
 *
 * @author huqj
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int m = (start + end) / 2;
            if (nums[m] == target) {
                return m;
            } else if (target < nums[m]) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{2, 3, 5, 6, 10}, 11));
    }
}
