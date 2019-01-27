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
        List<Integer> subList = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        solve(nums, 0, 0, target, subList, result);
        return new ArrayList<>(result);
    }

    //从前往后回溯凑齐4个数字看看是否满足
    private void solve(int[] nums, int startIndex, int sum, int target, List<Integer> subList, Set<List<Integer>> result) {
        //已经超过并且后面全是正数
//        if (sum > target && subList.size() > 0 && subList.get(subList.size() - 1) >= 0) {
//            return;
//        }
        if (subList.size() == 4 && sum == target) {
            result.add(new ArrayList<>(subList));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            subList.add(nums[i]);
            solve(nums, i + 1, sum + nums[i], target, subList, result);
            subList.remove(subList.size() - 1);  //回溯
        }
    }

    //递归
//    private void xSum(int x, int[] nums, int target, List<Integer> tmp, List<List<Integer>> ret, Set<String> set) {
//        if (x == 1) {
//            if (Arrays.binarySearch(nums, target) >= 0) {
//                tmp.add(target);
//                ArrayList<Integer> result = new ArrayList<>(tmp);
//                Collections.sort(result);
//                if (!set.contains(result.toString())) {
//                    ret.add(result);
//                    set.add(result.toString());
//                }
//                tmp.remove(tmp.size() - 1);  //回溯
//            }
//        } else {
//            int size = nums.length;
//            for (int i = 0; i < size; i++) {
//                int n = nums[i];
//                int[] newNums = new int[size - 1];
//                for (int k = 0; k < i; k++) {
//                    newNums[k] = nums[k];
//                }
//                int j = i;
//                for (int k = i + 1; k < size; k++) {
//                    newNums[j++] = nums[k];
//                }
//                tmp.add(n);
//                xSum(x - 1, newNums, target - n, tmp, ret, set);
//                tmp.remove(tmp.size() - 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(new _4Sum().fourSum(new int[]{1, 0, -2, 2, 0, -1}, 0));
        System.out.println(new _4Sum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

}
