package _0801_0850._831_Masking_Personal_Information;

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
    final String input = "LeetCode@LeetCode.com",
        expected = "l*****e@leetcode.com";
    assertEquals(expected, solution.maskPII(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "AB@qq.com",
        expected = "a*****b@qq.com";
    assertEquals(expected, solution.maskPII(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "1(234)567-890",
        expected = "***-***-7890";
    assertEquals(expected, solution.maskPII(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String input = "86-(10)12345678",
        expected = "+**-***-***-5678";
    assertEquals(expected, solution.maskPII(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String input = "+(501321)-50-23431",
        expected = "+***-***-***-3431";
    assertEquals(expected, solution.maskPII(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}