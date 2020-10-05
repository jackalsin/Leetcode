package _0051_0100._051_N_Queens;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 3/3/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith4(Solution solution) {
    List<List<String>> expected = List.of(
        List.of(".Q..", "...Q", "Q...", "..Q."),
        List.of("..Q.", "Q...", "...Q", ".Q..")
    ), actual = solution.solveNQueens(4);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

}