package google._399_Evaluate_Division;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 1/23/2018.
 */
public class SolutionTest {
  private static final double BIAS = 1E-8;

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) throws Exception {
    final List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c")),
        queries = List.of(
            List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
    final double[] values = {2.0, 3.0};
    final double[] expected = {6.0, 0.5, -1.0, 1.0, -1.0};
    final double[] actual = solution.calcEquation(equations, values, queries);
    assertArrayEquals(expected, actual, BIAS);
  }
}
