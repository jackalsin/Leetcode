package _0951_1000._985_Sum_of_Even_Numbers_After_Queries;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhixi
 * @version 1.0 on 10/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int A[] = {1, 2, 3, 4}, queries[][] = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}},
        expected[] = {8, 6, 2, 4}, actual[] = solution.sumEvenAfterQueries(A, queries);
    assertArrayEquals(expected, actual, "actual = " + actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}