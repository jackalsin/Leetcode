package interviews.byteDance._034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithSingleIndex(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertArrayEquals(new int[]{2, 2}, solution.searchRange(input, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithNotFoundSingleValue(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertArrayEquals(new int[]{-1, -1}, solution.searchRange(input, -1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithDupFindValue(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 3, 3, 4, 5};
    assertArrayEquals(new int[]{2, 4}, solution.searchRange(input, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithSingleValueArrayOdd(Solution solution) {
    final int[] input = new int[]{1};
    assertArrayEquals(new int[]{0, 0}, solution.searchRange(input, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithSingleValueArrayEven(Solution solution) {
    final int[] input = new int[]{2};
    assertArrayEquals(new int[]{0, 0}, solution.searchRange(input, 2));
  }


  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}