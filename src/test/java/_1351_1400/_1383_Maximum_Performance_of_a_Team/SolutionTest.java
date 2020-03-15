package _1351_1400._1383_Maximum_Performance_of_a_Team;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    //                             2   3  4  5                         2  3  4  5
    final int n = 6, speed[] = {2, 10, 3, 1, 5, 8}, efficiency[] = {5, 4, 3, 9, 7, 2}, k = 2;
    assertEquals(60, solution.maxPerformance(n, speed, efficiency, k));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }
}