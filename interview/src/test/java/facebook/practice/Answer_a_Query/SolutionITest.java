package facebook.practice.Answer_a_Query;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<Query> queries = List.of(
        Query.of(2, 3), Query.of(1, 2), Query.of(2, 1),
        Query.of(2, 3), Query.of(2, 2));
    final int N = 5, Q = 5, expected[] = {-1, 2, -1, 2}, actual[] = solution.answerQueries(queries, N);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}