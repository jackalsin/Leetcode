package _1001_1050._1003_Check_If_Word_Is_Valid_After_Substitutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhixi
 * @version 1.0 on 10/16/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String s = "aabcbc";
    assertTrue(solution.isValid(s));
//    "" -> "abc" -> "aabcbc"
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String s = "abcabcababcc";
    assertTrue(solution.isValid(s));
//    "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String s = "abccba";
    assertFalse(solution.isValid(s));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String s = "cababc";
    assertFalse(solution.isValid(s));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}