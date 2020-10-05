package _1401_1450._1409_Queries_on_a_Permutation_With_Key;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int queries[] = {3, 1, 2, 1}, m = 5,
        expected[] = {2, 1, 2, 1}, actual[] = solution.processQueries(queries, m);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int queries[] = {4, 1, 2, 2}, m = 4,
        expected[] = {3, 1, 2, 0}, actual[] = solution.processQueries(queries, m);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int queries[] = {7, 5, 5, 8, 3}, m = 8,
        expected[] = {6, 5, 0, 7, 5}, actual[] = solution.processQueries(queries, m);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}