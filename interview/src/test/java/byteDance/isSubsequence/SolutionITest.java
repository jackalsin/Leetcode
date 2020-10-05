package byteDance.isSubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/11/2020
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String S = "applebananawatermelon", D[] = {"aple", "apppple", "banana", "wtrmelon", ""};
    final boolean[] actual = solution.isSubsequence(D, S), expected = {
        true, false, true, true, true
    };
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new StringIteratorSolution()
    );
  }
}