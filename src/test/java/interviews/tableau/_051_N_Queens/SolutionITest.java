package interviews.tableau._051_N_Queens;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith4(Solution solution) throws Exception {
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList(".Q..", "...Q", "Q...", "..Q."));
    expected.add(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
    List<List<String>> actual = solution.solveNQueens(4);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}