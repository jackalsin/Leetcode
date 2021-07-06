package _0001_0050._036_Valid_Sudoku;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static definition.SudokuUtils.create2dSudokuArray;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/15/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final char[][] boards = create2dSudokuArray(
        new String[]{
            ".87654321", "2........", "3........",
            "4........", "5........", "6........",
            "7........", "8........", "9........"
        });
    assertTrue(solution.isValidSudoku(boards));
  }

}