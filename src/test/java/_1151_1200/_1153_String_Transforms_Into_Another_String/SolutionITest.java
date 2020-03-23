package _1151_1200._1153_String_Transforms_Into_Another_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/23/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String str1 = "leetcode", str2 = "codeleet";
    assertFalse(solution.canConvert(str1, str2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String str1 = "aabcc", str2 = "ccdee";
    assertTrue(solution.canConvert(str1, str2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String str1 = "aabcc", str2 = "cccee";
    assertTrue(solution.canConvert(str1, str2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String str1 = "abcdefghijklmnopqrstuvwxyz", str2 =
        "bcdefghijklmnopqrstuvwxyza";
    assertFalse(solution.canConvert(str1, str2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final String str1 = "abcdefghijklmnopqrstuvwxyz", str2 =
        "bcdefghijklmnopqrstuvwxyzq";
    assertTrue(solution.canConvert(str1, str2));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}