package airbnb._219_Contains_Duplicate_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/22/2021
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertFalse(solution.containsNearbyDuplicate(new int[]{}, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testUnorderedArray(Solution solution) {
    final int[] input = new int[]{1, 5, -3, 5, 2, 11, 7};
    assertTrue(solution.containsNearbyDuplicate(input, 4));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}