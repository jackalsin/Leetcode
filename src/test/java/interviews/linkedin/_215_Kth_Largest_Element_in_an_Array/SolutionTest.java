package interviews.linkedin._215_Kth_Largest_Element_in_an_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOneElement(Solution solution) {
    final int[] input = new int[]{1};
    assertEquals(1, solution.findKthLargest(input, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[] input = new int[]{3, 2, 1, 5, 6, 4};
    assertEquals(5, solution.findKthLargest(input, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testDuplicate(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 4, 5, 5, 5, 6};
    assertEquals(5, solution.findKthLargest(input, 2));
    assertEquals(4, solution.findKthLargest(input, 5));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }
}