package leetcode;

/**
 * leetcode: https://leetcode.com/problems/container-with-most-water/
 * result: success
 *
 * @author huqj
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            //判断是否可能作为边界
            boolean shouldConsider = true;
            if (i > 0 && i < height.length - 1) {
                boolean left = false;
                for (int k = i - 1; k >= 0; k--) {
                    if (height[k] >= height[i]) {
                        left = true;
                        break;
                    }
                }
                if (left) {
                    for (int j = i + 1; j < height.length; j++) {
                        if (height[j] >= height[i]) {
                            shouldConsider = false;
                            break;
                        }
                    }
                }
            }
            if (shouldConsider) {
                int maxHeight = Integer.MIN_VALUE;
                int maxPos = -1;
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] > maxHeight) {
                        maxHeight = height[j];
                        maxPos = j;
                    }
                }
                maxHeight = Math.min(height[i], maxHeight);
                int tmp = (maxPos - i) * Math.min(height[i], maxHeight);
                //从最大高度向后寻找
                for (int j = maxPos + 1; j < height.length; j++) {
                    int tmp2 = (j - i) * Math.min(height[i], height[j]);
                    if (tmp2 > tmp) {
                        tmp = tmp2;
                    }
                }
                //更新最大值
                if (tmp > ret) {
                    ret = tmp;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

}
