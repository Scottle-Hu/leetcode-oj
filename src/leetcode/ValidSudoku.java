package leetcode;

/**
 * leetcode: https://leetcode.com/problems/valid-sudoku/submissions/
 * result: success
 *
 * @author huqj
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[] nineDigit = new boolean[10];
        for (int i = 0; i < 9; i++) {
            //init
            for (int k = 0; k < 10; k++) {
                nineDigit[k] = false;
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = Integer.parseInt("" + board[i][j]);
                if (nineDigit[num]) {
                    return false;
                } else {
                    nineDigit[num] = true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            //init
            for (int k = 0; k < 10; k++) {
                nineDigit[k] = false;
            }
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int num = Integer.parseInt("" + board[j][i]);
                if (nineDigit[num]) {
                    return false;
                } else {
                    nineDigit[num] = true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //init
                for (int k = 0; k < 10; k++) {
                    nineDigit[k] = false;
                }
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        if (board[i * 3 + k][j * 3 + m] == '.') {
                            continue;
                        }
                        int num = Integer.parseInt("" + board[i * 3 + k][j * 3 + m]);
                        if (nineDigit[num]) {
                            return false;
                        } else {
                            nineDigit[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
       [[".",".","4",".",".",".","6","3","."],
       [".",".",".",".",".",".",".",".","."],
       ["5",".",".",".",".",".",".","9","."],
       [".",".",".","5","6",".",".",".","."],
       ["4",".","3",".",".",".",".",".","1"],
       [".",".",".","7",".",".",".",".","."],
       [".",".",".","5",".",".",".",".","."],
       [".",".",".",".",".",".",".",".","."],
       [".",".",".",".",".",".",".",".","."]]
         */
    }
}
