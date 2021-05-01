package facebook.practice.Reverse_to_Make_Equal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    int[] array_a_2 = {1, 2, 3, 4};
    int[] array_b_2 = {1, 4, 3, 3};
    assertFalse(solution.areTheyEqual(array_a_2, array_b_2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    int[] array_a_2 = {1, 2, 3, 4};
    int[] array_b_2 = {1, 4, 3, 3};
    assertFalse(solution.areTheyEqual(array_a_2, array_b_2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    int[] array_a_2 = {1, 2, 3, 4};
    int[] array_b_2 = {1, 4, 3, 2};
    assertTrue(solution.areTheyEqual(array_a_2, array_b_2));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseMultiDuplicateSection(Solution solution) {
    int[] array_a_2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] array_b_2 = {1, 4, 3, 2, 5, 9, 8, 7, 6};
    assertFalse(solution.areTheyEqual(array_a_2, array_b_2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}