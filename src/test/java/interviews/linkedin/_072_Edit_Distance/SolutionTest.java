package interviews.linkedin._072_Edit_Distance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithEmptyCouples(Solution solution) {
    assertEquals(0, solution.minDistance("", ""));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithEmpty(Solution solution) {
    assertEquals(5, solution.minDistance("", "word1"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithCommonCase1(Solution solution) {
    assertEquals(2, solution.minDistance("word", "wcd"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithFailedCase1(Solution solution) {
    assertEquals(5, solution.minDistance("intention", "execution"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}