package interviews.linkedin._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) throws Exception {
    final String s = "eceba";
    assertEquals(3, solution.lengthOfLongestSubstringKDistinct(s, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) throws Exception {
    final String s = "aa";
    assertEquals(2, solution.lengthOfLongestSubstringKDistinct(s, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testKEquals0(Solution solution) throws Exception {
    final String s = "abaccc";
    assertEquals(4, solution.lengthOfLongestSubstringKDistinct(s, 2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}