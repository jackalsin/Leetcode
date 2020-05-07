package interviews.byteDance._051_N_Queens;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 5/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith4(Solution solution) {
    List<List<String>> expected = List.of(
        List.of(".Q..", "...Q", "Q...", "..Q."),
        List.of("..Q.", "Q...", "...Q", ".Q..")
    ), actual = solution.solveNQueens(4);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}