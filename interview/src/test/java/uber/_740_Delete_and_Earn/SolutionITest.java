package uber._740_Delete_and_Earn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/16/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(6, solution.deleteAndEarn(new int[]{3, 4, 2}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(9, solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    assertEquals(18, solution.deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    assertEquals(11, solution.deleteAndEarn(new int[]{1, 5, 5}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    assertEquals(52, solution.deleteAndEarn(new int[]{8, 7, 3, 8, 1, 4, 10, 10, 10, 2}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    assertEquals(37, solution.deleteAndEarn(new int[]{8, 10, 4, 9, 1, 3, 5, 9, 4, 10}));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}