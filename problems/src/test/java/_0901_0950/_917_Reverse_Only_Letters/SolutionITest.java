package _0901_0950._917_Reverse_Only_Letters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "ab-cd", expected = "dc-ba", actual = solution.reverseOnlyLetters(s);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String s = "a-bC-dEf-ghIj",
        expected = "j-Ih-gfE-dCba",
        actual = solution.reverseOnlyLetters(s);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String s = "Test1ng-Leet=code-Q!",
        expected = "Qedo1ct-eeLg=ntse-T!",
        actual = solution.reverseOnlyLetters(s);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}