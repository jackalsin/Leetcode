package airbnb.oa.costOfModule;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 6/28/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[][] input = {
        {"A", "E", "N", "S"},
        {"S", "H", "N"},
        {"E", "N"},
        {"H"},
        {"N"},
    };
    final String[] actual = solution.costOfModule(input),
        expected = {"A,1", "E,2", "H,3", "N,4", "S,2"};
    Arrays.sort(actual);
    Arrays.sort(expected);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}