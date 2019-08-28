package _0951_1000._973_K_Closest_Points_to_Origin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {{1, 3}, {-2, 2}}, expected = {{-2, 2}};
    final int K = 1;
    assertArrayEquals(expected, solution.kClosest(input, K));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {{3, 3}, {5, -1}, {-2, 4}}, expected = {{3, 3}, {-2, 4}};
    final int K = 2;
    assertArrayEquals(expected, solution.kClosest(input, K));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOverflows(Solution solution) {
    final int[][] input = {{3, 3}, {Integer.MIN_VALUE, Integer.MIN_VALUE}}, expected = {{3, 3}};
    final int K = 1;
    assertArrayEquals(expected, solution.kClosest(input, K));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }


}