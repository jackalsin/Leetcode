package hulu._358_Rearrange_String_k_Distance_Apart;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static definition._358_Rearrange_String_k_Distance_Apart.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/22/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    final int k = 3;
    final String input = "aabbcc", actual = solution.rearrangeString(input, k);
    assertTrue(actual, input, k);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final int k = 3;
    final String input = "aabbcc", actual = solution.rearrangeString(input, k);
    assertEquals("", solution.rearrangeString("aaabc", k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final int k = 2;
    final String input = "aabbcc", actual = solution.rearrangeString(input, k);
    assertTrue(actual, input, k);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}