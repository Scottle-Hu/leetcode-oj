package leetcode;

/**
 * leetcode: https://leetcode.com/problems/zigzag-conversion/
 * result: success
 *
 * @author huqj
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (s.length() < 2 || numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int size = chars.length;
        int gNum = numRows * 2 - 2;
        int mod = size % gNum;
        int colNum = (size / gNum) * 2;
        int tailNum = 0;
        if (mod > numRows) {
            tailNum = mod - numRows + 1;
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int rowLen = tailNum > 0
                    ? (i >= numRows - tailNum ? colNum + 2 : colNum + 1)
                    : (i < mod ? colNum + 1 : colNum);
            for (int j = 0; j < rowLen; j++) {
                //为空的位置
                if ((i == 0 || i == numRows - 1) && j % 2 == 1) {
                    continue;
                }
                //非空位置通过坐标找到字符
                int index = (j / 2) * gNum;
                if (j % 2 == 0) {
                    index += i;
                } else {
                    index += (numRows + (numRows - 2 - i));
                }
                ret.append(s.charAt(index));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("ABCDE", 3));
    }

}
