package _1551_1600._1594_Maximum_Non_Negative_Product_in_a_Matrix;

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
    final int grid[][] = {
        {-1, -2, -3},
        {-2, -3, -3},
        {-3, -3, -2}
    }, expected = -1, actual = solution.maxProductPath(grid);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int grid[][] = {
        {1, -2, 1},
        {1, -2, 1},
        {3, -4, 1}
    }, expected = 8, actual = solution.maxProductPath(grid);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int grid[][] = {
        {-1, -2, -3},
        {-2, -3, -3},
        {-3, -3, -2}
    }, expected = -1, actual = solution.maxProductPath(grid);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}