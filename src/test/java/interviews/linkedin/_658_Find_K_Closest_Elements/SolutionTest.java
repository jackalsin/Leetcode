package interviews.linkedin._658_Find_K_Closest_Elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] arr = {1, 2, 3, 4, 5};
    final int k = 4, x = 3;
    assertEquals(List.of(1, 2, 3, 4), solution.findClosestElements(arr, k, x));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] arr = {1, 2, 3, 4, 5};
    final int k = 4, x = -1;
    assertEquals(List.of(1, 2, 3, 4), solution.findClosestElements(arr, k, x));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] arr = {1, 2, 3, 4, 5};
    final int k = 4, x = 4;
    assertEquals(List.of(2, 3, 4, 5), solution.findClosestElements(arr, k, x));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new PriorityQueueSolution(),
        new BinarySearchSolution()
    );
  }
}