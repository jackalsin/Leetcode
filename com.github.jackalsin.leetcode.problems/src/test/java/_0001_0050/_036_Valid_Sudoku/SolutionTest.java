package _0001_0050._036_Valid_Sudoku;

import org.junit.Before;
import org.junit.Test;

import static definition.SudokuUtils.create2dSudokuArray;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/15/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithCase1() throws Exception {
    final char[][] boards = create2dSudokuArray(
        new String[]{
            ".87654321", "2........", "3........",
            "4........", "5........", "6........",
            "7........", "8........", "9........"
        });
    assertTrue(solution.isValidSudoku(boards));
  }

}