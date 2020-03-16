package _0801_0850._809_Expressive_Words;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "heeellooo", words[] = {
        "hello", "hi", "helo"
    };
    assertEquals(1, solution.expressiveWords(s, words));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final String s = "zzzzzyyyyy", words[] = {
        "zzyy", "zy", "zyy"
    };
    assertEquals(3, solution.expressiveWords(s, words));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new BestSolution()
    );
  }
}