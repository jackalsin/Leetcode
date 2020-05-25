package explore._1035_Uncrossed_Lines;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
class SolutionITest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] A = {1, 4, 2}, B = {1, 2, 4};
    assertEquals(2, solution.maxUncrossedLines(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] A = {2, 5, 1, 2, 5}, B = {10, 5, 2, 1, 5, 2};
    assertEquals(3, solution.maxUncrossedLines(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] A = {1, 3, 7, 1, 7, 5}, B = {1, 9, 2, 5, 1};
    assertEquals(2, solution.maxUncrossedLines(A, B));
  }
}