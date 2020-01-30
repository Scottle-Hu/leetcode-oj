package leetcode;

import java.util.Arrays;

/**
 * leetcode: https://leetcode.com/problems/next-permutation/
 * result: success
 *
 * @author huqj
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int temp = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            //从后往前找到第一个非逆序的位置
            if (nums[i] < nums[i + 1]) {
                for (int k = nums.length - 1; k > i; k--) {
                    if (nums[k] > nums[i]) {
                        //找到该数的下一个数并互换位置
                        temp = nums[i];
                        nums[i] = nums[k];
                        nums[k] = temp;
                        //i+1 ~ nums.length 由原本的倒序排列改为正序排列
                        int medium = (nums.length + i + 1) / 2;
                        for (int m = i + 1; m < medium; m++) {
                            temp = nums[m];
                            nums[m] = nums[nums.length + i - m];
                            nums[nums.length + i - m] = temp;
                        }
                        //over
                        return;
                    }
                }
            }
        }
        //说明整个数组都是逆序，直接正序排列
        int m = nums.length / 2;
        for (int i = 0; i < m; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 5};
        new NextPermutation().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
