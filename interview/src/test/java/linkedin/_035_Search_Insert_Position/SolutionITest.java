package linkedin._035_Search_Insert_Position;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }

  // non-exist value
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithLeadingValue(Solution solution) {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(0, solution.searchInsert(input, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithTrailingValue(Solution solution) {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(5, solution.searchInsert(input, 10));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithMidMissingValue(Solution solution) {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(3, solution.searchInsert(input, 6));
  }
  //test for existing value

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith0thValue(Solution solution) {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(0, solution.searchInsert(input, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithLastValue(Solution solution) {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(4, solution.searchInsert(input, 9));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithMidValue(Solution solution) {
    final int[] input = new int[]{1, 3, 5, 7, 9};
    assertEquals(2, solution.searchInsert(input, 5));
  }
}