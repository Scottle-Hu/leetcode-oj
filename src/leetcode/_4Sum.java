package leetcode;

import java.util.*;

/**
 * leetcode: https://leetcode.com/problems/4sum/
 * result: time limit exceeded
 *
 * @author huqj
 */
public class _4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();
        xSum(4, nums, target, new ArrayList<>(), ret, set);
        return ret;
    }

    //递归
    private void xSum(int x, int[] nums, int target, List<Integer> tmp, List<List<Integer>> ret, Set<String> set) {
        if (x == 1) {
            if (Arrays.binarySearch(nums, target) >= 0) {
                tmp.add(target);
                ArrayList<Integer> result = new ArrayList<>(tmp);
                Collections.sort(result);
                if (!set.contains(result.toString())) {
                    ret.add(result);
                    set.add(result.toString());
                }
                tmp.remove(tmp.size() - 1);  //回溯
            }
        } else {
            int size = nums.length;
            for (int i = 0; i < size; i++) {
                int n = nums[i];
                int[] newNums = new int[size - 1];
                for (int k = 0; k < i; k++) {
                    newNums[k] = nums[k];
                }
                int j = i;
                for (int k = i + 1; k < size; k++) {
                    newNums[j++] = nums[k];
                }
                tmp.add(n);
                xSum(x - 1, newNums, target - n, tmp, ret, set);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(new _4Sum().fourSum(new int[]{1, 0, -2, 2, 0, -1}, 0));
        System.out.println(new _4Sum().fourSum(new int[]{-500, -481, -480, -469, -437, -423, -408, -403, -397, -381,
                -379, -377, -353, -347, -337, -327, -313, -307, -299, -278, -265, -258, -235, -227, -225, -193, -192,
                -177, -176, -173, -170, -164, -162, -157, -147, -118, -115, -83, -64, -46, -36, -35, -11, 0, 0, 33,
                40, 51, 54, 74, 93, 101, 104, 105, 112, 112, 116, 129, 133, 146, 152, 157, 158, 166, 177, 183, 186,
                220, 263, 273, 320, 328, 332, 356, 357, 363, 372, 397, 399, 420, 422, 429, 433, 451, 464, 484, 485,
                498, 499}, 2139));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

}
