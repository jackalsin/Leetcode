package interviews.tableau.rearrangeOrder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {0, 1, 2, 3, 4, 5};
    solution.rearrange(input);
//    System.out.println(Arrays.toString(input));
    assertTrue(isOddEven(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1, 0, 3, 5, 4, 2};
    solution.rearrange(input);
//    System.out.println(Arrays.toString(input));
    assertTrue(isOddEven(input));
  }

  private static boolean isOddEven(final int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      if (i % 2 == 0) {
        if (nums[i] % 2 != 0) return false;
      } else { // odd
        if (nums[i] % 2 == 0) return false;
      }
    }
    return true;
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}