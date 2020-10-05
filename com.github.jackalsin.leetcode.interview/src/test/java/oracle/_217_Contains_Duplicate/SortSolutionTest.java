package oracle._217_Contains_Duplicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/16/2019
 */
class SortSolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {1, 2, 3, 1};
    assertTrue(solution.containsDuplicate(nums));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SortSolution(),
        new SetSolution()
    );
  }
}