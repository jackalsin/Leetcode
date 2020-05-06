package interviews.byteDance._033_Search_in_Rotated_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
class SolutionITest {

  private static final int[] LEFT_SORT = new int[]{4, 5, 6, 8, 10, 0, 1, 2};
  private static final int[] RIGHT_SORT = new int[]{6, 7, 9, 0, 1, 3, 4, 5};

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithLeftSortedTargetLeftFound(Solution solution) {
    assertEquals(2, solution.search(LEFT_SORT, 6));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithLeftSortedTargetLeftNotFound(Solution solution) {
    assertEquals(-1, solution.search(LEFT_SORT, 7));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithLeftSortedTargetRightFound(Solution solution) {
    assertEquals(LEFT_SORT.length - 1, solution.search(LEFT_SORT, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithLeftSortedTargetRightNotFound(Solution solution) {
    assertEquals(-1, solution.search(LEFT_SORT, 11));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithLeftSortedTargetNotBetweenEnds(Solution solution) {
    assertEquals(-1, solution.search(LEFT_SORT, 3));
  }

  // -------- right sorted ---------
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithRightSortedTargetLeftFound(Solution solution) {
    assertEquals(1, solution.search(RIGHT_SORT, 7));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithRightSortedTargetLeftNotFound(Solution solution) {
    assertEquals(-1, solution.search(RIGHT_SORT, 8));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithRightSortedTargetRightFound(Solution solution) {
    assertEquals(5, solution.search(RIGHT_SORT, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithRightSortedTargetRightNotFound(Solution solution) {
    assertEquals(-1, solution.search(RIGHT_SORT, 8));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}