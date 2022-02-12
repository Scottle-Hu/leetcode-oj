package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/
 */
public class SmallestRotationWithHighestScore {

    public int bestRotation(int[] nums) {
        List<Integer> moveStep = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            moveStep.add(0);
        }
        int lastScore = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= i) {
                lastScore++;
                moveStep.set(i - nums[i], moveStep.get(i - nums[i]) + 1);
            } else {
                moveStep.set(i + nums.length - nums[i], moveStep.get(i + nums.length - nums[i]) + 1);
            }
        }
        int minK = 0;
        int maxScore = lastScore;
        for (int i = 1; i < nums.length; i++) {
            lastScore = lastScore + 1 - moveStep.get(i - 1);
            if (lastScore > maxScore) {
                maxScore = lastScore;
                minK = i;
            }
        }
        return minK;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestRotationWithHighestScore().bestRotation(new int[]{2, 3, 1, 4, 0}));
    }
}
