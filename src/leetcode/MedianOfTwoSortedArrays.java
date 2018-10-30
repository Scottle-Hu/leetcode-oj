package leetcode;

/**
 * leetcode: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * result: success
 *
 * @author huqj
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length != 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2] + nums2[(nums2.length / 2) - 1]) / 2.0;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2.length == 0 && nums1.length != 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2] + nums1[(nums1.length / 2) - 1]) / 2.0;
            } else {
                return nums1[nums1.length / 2];
            }
        }
        int[][] nums = {nums1, nums2};
        int[] i = {0, 0}, j = {nums1.length - 1, nums2.length - 1};
        int head = nums1[i[0]] < nums2[i[1]] ? 0 : 1, tail = nums1[j[0]] > nums2[j[1]] ? 0 : 1;
        double ret;
        while (true) {
            if (i[0] == j[0] && i[1] == j[1]) {
                ret = (nums[head][i[head]] + nums[tail][j[tail]]) / 2.0;
                break;
            }
            if (i[head] < j[head]) {
                i[head]++;
            } else {
                j[tail]--;
                if ((j[tail] - i[tail]) % 2 == 0) {
                    ret = nums[tail][i[tail] + ((j[tail] - i[tail]) / 2)];
                } else {
                    int len = (j[tail] - i[tail]) / 2;
                    ret = (nums[tail][i[tail] + len] + nums[tail][j[tail] - len]) / 2.0;
                }
                break;
            }
            head = nums[0][i[0]] <= nums[1][i[1]] ? 0 : 1;
            if (i[0] == j[0] && i[1] == j[1]) {
                ret = nums[head][i[head]];
                break;
            }
            if (j[tail] > i[tail]) {
                j[tail]--;
            } else {
                if ((j[head] - i[head]) % 2 == 0) {
                    ret = nums[head][i[head] + ((j[head] - i[head]) / 2)];
                } else {
                    int len = (j[head] - i[head]) / 2;
                    ret = (nums[head][i[head] + len] + nums[head][j[head] - len]) / 2.0;
                }
                break;
            }
            tail = nums[0][j[0]] >= nums[1][j[1]] ? 0 : 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num1 = {1}, num2 = {-1, 3};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(num1, num2));
    }

}
