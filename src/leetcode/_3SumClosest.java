package leetcode;

import java.util.Arrays;

/**
 * leetcode: https://leetcode.com/problems/3sum-closest/
 * result: success
 *
 * @author huqj
 */
public class _3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int ret = 0, delta = Integer.MAX_VALUE, len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    boolean toPositive = nums[k] >= 0;
                    int tmp = nums[i] + nums[j] + nums[k];
                    int d2 = tmp - target;
                    if (d2 == 0 || Math.abs(d2) < delta) {
                        delta = Math.abs(d2);
                        ret = tmp;
                    } else if (toPositive && d2 > 0) {
                        break;
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new _3SumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

}
