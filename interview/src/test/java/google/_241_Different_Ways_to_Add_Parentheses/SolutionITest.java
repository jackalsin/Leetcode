package google._241_Different_Ways_to_Add_Parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/27/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final String input = "2-1-1";
    final List<Integer> actual = solution.diffWaysToCompute(input);
    final List<Integer> expected = Arrays.asList(0, 2);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final String input = "2*3-4*5";
    final List<Integer> actual = solution.diffWaysToCompute(input);
    final List<Integer> expected = Arrays.asList(-34, -14, -10, -10, 10);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}