package _1051_1100._1071_Greatest_Common_Divisor_of_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String str1 = "ABCABC", str2 = "ABC";
    assertEquals("ABC", solution.gcdOfStrings(str1, str2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String str1 = "ABABAB", str2 = "ABAB";
    assertEquals("AB", solution.gcdOfStrings(str1, str2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String str1 = "LEET", str2 = "CODE";
    assertEquals("", solution.gcdOfStrings(str1, str2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String str1 = "ABCDEF", str2 = "ABC";
    assertEquals("", solution.gcdOfStrings(str1, str2));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}