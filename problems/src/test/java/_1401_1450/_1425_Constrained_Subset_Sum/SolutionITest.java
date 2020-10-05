package _1401_1450._1425_Constrained_Subset_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(37, solution.constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(-1, solution.constrainedSubsetSum(new int[]{-1, -2, -3}, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    assertEquals(23, solution.constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    assertEquals(23, solution.constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    assertEquals(16091, solution.constrainedSubsetSum(new int[]{-8269, 3217, -4023, -4138, -683, 6455, -3621, 9242,
        4015, -3790}, 1));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}