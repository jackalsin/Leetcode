package _0951_1000._960_Delete_Columns_to_Make_Sorted_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"babca", "bbazb"};
    assertEquals(3, solution.minDeletionSize(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] input = {"edcba"};
    assertEquals(4, solution.minDeletionSize(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] input = {"ghi", "def", "abc"};
    assertEquals(0, solution.minDeletionSize(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String[] input = {"aabbaa", "baabab", "aaabab"};
    // keep 1, 4, 5
    assertEquals(3, solution.minDeletionSize(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}