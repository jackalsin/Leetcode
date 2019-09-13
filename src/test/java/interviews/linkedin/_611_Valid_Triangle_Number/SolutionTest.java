package interviews.linkedin._611_Valid_Triangle_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {2, 2, 3, 4};
    assertEquals(3, solution.triangleNumber(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testDuplicate1(Solution solution) {
    final int[] input = {2, 2, 2, 3, 4};
    assertEquals(7, solution.triangleNumber(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed2(Solution solution) {
    final int[] input = {0, 1, 0};
    assertEquals(0, solution.triangleNumber(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }
}