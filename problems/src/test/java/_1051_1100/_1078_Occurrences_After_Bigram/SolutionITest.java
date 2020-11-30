package _1051_1100._1078_Occurrences_After_Bigram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String text = "alice is a good girl she is a good student", first = "a", second = "good",
        expected[] = {"girl", "student"}, actual[] = solution.findOcurrences(text, first, second);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String text = "we will we will rock you", first = "we", second = "will",
        expected[] = {"we", "rock"}, actual[] = solution.findOcurrences(text, first, second);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}