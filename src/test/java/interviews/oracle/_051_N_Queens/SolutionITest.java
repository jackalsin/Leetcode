package interviews.oracle._051_N_Queens;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList(".Q..", "...Q", "Q...", "..Q."));
    expected.add(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
    List<List<String>> actual = solution.solveNQueens(4);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}