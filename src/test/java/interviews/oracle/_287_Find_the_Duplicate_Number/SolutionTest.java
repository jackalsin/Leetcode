package interviews.oracle._287_Find_the_Duplicate_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/23/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test11(Solution solution) {
    final int[] input = new int[]{1, 1};
    assertEquals(1, solution.findDuplicate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test112(Solution solution) {
    final int[] input = new int[]{1, 1, 2};
    assertEquals(1, solution.findDuplicate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test122(Solution solution) {
    final int[] input = new int[]{1, 2, 2};
    assertEquals(2, solution.findDuplicate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Solution solution) {
    final int[] input = {1, 3, 4, 2, 1};
    assertEquals(1, solution.findDuplicate(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    final int[] input = {1, 3, 4, 1, 2};
    assertEquals(1, solution.findDuplicate(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}