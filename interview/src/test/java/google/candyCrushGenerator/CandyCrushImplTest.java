package google.candyCrushGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author jacka
 * @version 1.0 on 4/29/2021
 */
class CandyCrushImplTest {
  private static final double BIAS = 1E-3;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<CandyCrush> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    CandyCrush solution = solutionClass.getConstructor(Integer.TYPE, Integer.TYPE).newInstance(5, 5);
    final int[][] board = solution.getBoard();
    assertValid(board);
  }

  @Test
  void testGetColorInvalid() {
    CandyCrushImpl solution = new CandyCrushImpl(3, 2);
    final Map<Integer, Integer> count = new HashMap<>();
    final List<Integer> invalid = new ArrayList<>() {{
      add(2);
    }};
    final int total = 1_000_000;
    for (int i = 0; i < total; ++i) {
      final int res = solution.getColor(invalid);
      count.put(res, count.getOrDefault(res, 0) + 1);
    }
    assertEquals(0.25, (double) count.get(0) / total, BIAS);
    assertEquals(0.25, (double) count.get(1) / total, BIAS);
    assertEquals(0.25, (double) count.get(3) / total, BIAS);
    assertEquals(0.25, (double) count.get(4) / total, BIAS);
  }

  private void assertValid(final int[][] board) {
    if (board == null) fail();
    final int rows = board.length;
    if (rows == 0) fail();
    final int cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (row >= 2) assertFalse(board[row][col] == board[row - 1][col] && board[row - 1][col] == board[row - 2][col]);
        if (col >= 2) assertFalse(board[row][col] == board[row][col - 1] && board[row][col] == board[row][col - 2]);
      }
    }
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        CandyCrushImpl.class
    );
  }
}