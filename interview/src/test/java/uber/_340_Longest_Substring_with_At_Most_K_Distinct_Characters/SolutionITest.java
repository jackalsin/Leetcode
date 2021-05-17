package uber._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/16/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    final String s = "eceba";
    assertEquals(3, solution.lengthOfLongestSubstringKDistinct(s, 2));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testKEquals0(Solution solution) {
    final String s = "abaccc";
    assertEquals(4, solution.lengthOfLongestSubstringKDistinct(s, 2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}