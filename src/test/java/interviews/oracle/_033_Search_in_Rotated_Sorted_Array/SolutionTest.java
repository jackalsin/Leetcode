package interviews.oracle._033_Search_in_Rotated_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
class SolutionTest {
  private static final int[] LEFT_SORT = new int[]{4, 5, 6, 8, 10, 0, 1, 2};
  private static final int[] RIGHT_SORT = new int[]{6, 7, 9, 0, 1, 3, 4, 5};

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithLeftSortedTargetLeftFound(Solution solution) {
    assertEquals(2, solution.search(LEFT_SORT, 6));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithLeftSortedTargetLeftNotFound(Solution solution) {
    assertEquals(-1, solution.search(LEFT_SORT, 7));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithLeftSortedTargetRightFound(Solution solution) {
    assertEquals(LEFT_SORT.length - 1, solution.search(LEFT_SORT, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithLeftSortedTargetRightNotFound(Solution solution) {
    assertEquals(-1, solution.search(LEFT_SORT, 11));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithLeftSortedTargetNotBetweenEnds(Solution solution) {
    assertEquals(-1, solution.search(LEFT_SORT, 3));
  }

  // -------- right sorted ---------
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithRightSortedTargetLeftFound(Solution solution) {
    assertEquals(1, solution.search(RIGHT_SORT, 7));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithRightSortedTargetLeftNotFound(Solution solution) {
    assertEquals(-1, solution.search(RIGHT_SORT, 8));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithRightSortedTargetRightFound(Solution solution) {
    assertEquals(5, solution.search(RIGHT_SORT, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithRightSortedTargetRightNotFound(Solution solution) {
    assertEquals(-1, solution.search(RIGHT_SORT, 8));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith3_1_1(Solution solution) {
    assertEquals(1, solution.search(new int[]{3, 1}, 1));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}