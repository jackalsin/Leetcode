package _0701_0750._702_Search_in_a_Sorted_Array_of_Unknown_Size;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._702_Search_in_a_Sorted_Array_of_Unknown_Size.ArrayReader;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final ArrayReader ar = new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12});
    final int target = 9;
    assertEquals(4, solution.search(ar, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final ArrayReader ar = new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12});
    final int target = 2;
    assertEquals(-1, solution.search(ar, target));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII());
  }
}