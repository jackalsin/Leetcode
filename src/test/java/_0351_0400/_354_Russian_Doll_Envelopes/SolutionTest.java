package _0351_0400._354_Russian_Doll_Envelopes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/9/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase(Solution solution) {
    final int[][] input = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    assertEquals(3, solution.maxEnvelopes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testEmpty(Solution solution) {
    final int[][] input = {};
    assertEquals(0, solution.maxEnvelopes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase2(Solution solution) {
    final int[][] input = {{5, 4}, {6, 5}, {6, 7}, {2, 3}, {7, 6}};
    assertEquals(4, solution.maxEnvelopes(input));
  }

}
