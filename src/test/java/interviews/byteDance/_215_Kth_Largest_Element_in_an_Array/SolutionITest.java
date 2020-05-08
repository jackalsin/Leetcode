package interviews.byteDance._215_Kth_Largest_Element_in_an_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOneElement(Solution solution){
    final int[] input = new int[]{1};
    assertEquals(1, solution.findKthLargest(input, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution){
    final int[] input = new int[]{3, 2, 1, 5, 6, 4};
    assertEquals(5, solution.findKthLargest(input, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testDuplicate(Solution solution){
    final int[] input = new int[]{1, 2, 3, 4, 5, 5, 5, 6};
    assertEquals(5, solution.findKthLargest(input, 2));
    assertEquals(4, solution.findKthLargest(input, 5));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}