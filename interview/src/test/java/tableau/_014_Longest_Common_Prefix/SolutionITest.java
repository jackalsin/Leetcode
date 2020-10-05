package tableau._014_Longest_Common_Prefix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void longestCommonPrefixSingleCommonMidString(Solution solution) {
    final String[] input = {"flower", "flow", "flight"};
    assertEquals("fl", solution.longestCommonPrefix(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void longestCommon2(Solution solution) {
    final String[] input = {"dog", "racecar", "car"};
    assertEquals("", solution.longestCommonPrefix(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void longestCommon3(Solution solution) {
    final String[] input = {"", "b"};
    assertEquals("", solution.longestCommonPrefix(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void longestCommon4(Solution solution) {
    final String[] input = {"a"};
    assertEquals("a", solution.longestCommonPrefix(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}