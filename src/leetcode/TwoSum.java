package leetcode;

import java.util.Arrays;

/**
 * leetcode: https://leetcode.com/problems/two-sum/
 * result: success
 *
 * @author huqj
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        outer:
        for (int i = 0; i < len; i++) {
            result[0] = i;
            int need = target - nums[i];
            for (int j = i + 1; j < len; j++) {
                if (need == nums[j]) {
                    result[1] = j;
                    break outer;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

}
