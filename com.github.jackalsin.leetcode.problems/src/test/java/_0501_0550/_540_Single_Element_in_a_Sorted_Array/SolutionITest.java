package _0501_0550._540_Single_Element_in_a_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 1, 2, 3, 3, 4, 4, 8, 8};
    final int expected = 2;
    assertEquals(expected, solution.singleNonDuplicate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {3, 3, 7, 7, 10, 11, 11};
    final int expected = 10;
    assertEquals(expected, solution.singleNonDuplicate(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}