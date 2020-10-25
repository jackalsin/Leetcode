package _1001_1050._1043_Partition_Array_for_Maximum_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int input[] = {1, 15, 7, 9, 2, 5, 10}, k = 3,
        expected = 84, actual = solution.maxSumAfterPartitioning(input, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int input[] = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, k = 4,
        expected = 83, actual = solution.maxSumAfterPartitioning(input, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int input[] = {1}, k = 1,
        expected = 1, actual = solution.maxSumAfterPartitioning(input, k);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}