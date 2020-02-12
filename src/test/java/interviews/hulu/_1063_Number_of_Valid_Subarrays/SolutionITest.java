package interviews.hulu._1063_Number_of_Valid_Subarrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 4, 2, 5, 3};
    assertEquals(11, solution.validSubarrays(input));
    //Explanation: There are 11 valid subarrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] input = {2, 2, 2};
    assertEquals(6, solution.validSubarrays(input));
//    There are 6 valid subarrays: [2],[2],[2],[2, 2],[2, 2],[2, 2, 2].
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] input = {3, 2, 1};
    assertEquals(3, solution.validSubarrays(input));
//    The 3 valid subarrays are: [3],[2],[1].
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}