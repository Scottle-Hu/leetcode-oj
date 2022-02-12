package leetcode;

/**
 * https://leetcode-cn.com/problems/additive-number/
 */
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        int firstMaxLen = num.length() - 2;
        if (num.charAt(0) == '0') {
            firstMaxLen = 1;
        }
        for (int firstNumLen = 1; firstNumLen <= firstMaxLen; firstNumLen++) {
            int secondMaxLen = num.length() - firstNumLen - 1;
            if (num.charAt(firstNumLen) == '0') {
                secondMaxLen = 1;
            }
            for (int secondNumLen = 1; secondNumLen <= secondMaxLen; secondNumLen++) {
                int startIndex = 0;
                int firstNumIndex = firstNumLen;
                int secondNumIndex = firstNumLen + secondNumLen;

                while (true) {
                    long firstNum = Long.parseLong(num.substring(startIndex, firstNumIndex));
                    long secondNum = Long.parseLong(num.substring(firstNumIndex, secondNumIndex));
                    String sumStr = String.valueOf(firstNum + secondNum);
                    if (num.substring(secondNumIndex).startsWith(sumStr)) {
                        if (num.substring(secondNumIndex).equals(sumStr)) {
                            return true;
                        }
                        startIndex = firstNumIndex;
                        firstNumIndex = secondNumIndex;
                        secondNumIndex = firstNumIndex + sumStr.length();
                    } else {
                        break;
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        //1，99，100，199
        System.out.println(new AdditiveNumber().isAdditiveNumber("199100199"));;
    }
}
