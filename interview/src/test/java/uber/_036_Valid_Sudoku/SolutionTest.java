package uber._036_Valid_Sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static definition.SudokuUtils.create2dSudokuArray;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/13/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithCase1() throws Exception {
    final char[][] boards = create2dSudokuArray(
        new String[] {
            ".87654321", "2........", "3........",
            "4........", "5........", "6........",
            "7........", "8........", "9........"
        });
    assertTrue(solution.isValidSudoku(boards));
  }

}
