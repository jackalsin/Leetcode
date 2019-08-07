package interviews.linkedin._154_Find_Minimum_in_Rotated_Sorted_Array_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  // non duplicated test cases
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOneElement(Solution solution) {
    final int[] input = new int[]{1};
    assertEquals(1, solution.findMin(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testTwoElement(Solution solution) {
    final int[] input = new int[]{1, 2};
    assertEquals(1, solution.findMin(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testTwoElements(Solution solution) {
    final int[] input = new int[]{2, 1};
    assertEquals(1, solution.findMin(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test5Elements(Solution solution) {
    final int[] input = new int[]{2, 3, 4, 0, 1};
    assertEquals(0, solution.findMin(input));
  }

  // duplicated test cases
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testDup1(Solution solution) {
    final int[] input = new int[]{2, 2, 2, 0, 1};
    assertEquals(0, solution.findMin(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testDup2(Solution solution) {
    final int[] input = new int[]{1, 3, 3};
    assertEquals(1, solution.findMin(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}