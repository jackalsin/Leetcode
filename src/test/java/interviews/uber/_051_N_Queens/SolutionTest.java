package interviews.uber._051_N_Queens;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/12/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    List<List<String>> actual = solution.solveNQueens(4);
    final Set<List<String>> expected = Set.of(
        List.of(".Q..",  // Solution 1
            "...Q",
            "Q...",
            "..Q."),
        List.of("..Q.",  // Solution 2
            "Q...",
            "...Q",
            ".Q.."));
    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  void testOnlineCase9() {
    final long startTime = System.nanoTime();
    List<List<String>> actual = solution.solveNQueens(9);
    final long endTime = System.nanoTime();
    System.out.println((endTime - startTime) / 1E6 + " ms");
  }
}
