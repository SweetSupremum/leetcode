package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * {@see https://leetcode.com/problems/valid-sudoku/description/}
 *
 * @author SweetSupremum
 */
public class ValidSudoku {

    public static void main(String[] args) {
        new ValidSudoku().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> checker = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char row = board[i][j];
                if (row == '.') {
                    continue;
                }
                if (!checker.add(i + "r" + row) || !checker.add(row + "c" + j) || !checker.add(i / 3 + "r" + row + "c" + j / 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
