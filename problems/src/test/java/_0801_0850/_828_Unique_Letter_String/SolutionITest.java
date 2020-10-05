package _0801_0850._828_Unique_Letter_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "ABC";
    assertEquals(10, solution.uniqueLetterString(input));
    // "A","B","C","AB","BC" and "ABC".
    // 1 + 1 + 1 + 2 + 2 + 3 = 10
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "ABA";
    assertEquals(8, solution.uniqueLetterString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "LEETCODE";
    assertEquals(92, solution.uniqueLetterString(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}