package _0651_0700._660_Remove_9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 3/9/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(8, solution.newInteger(8));
    assertEquals(10, solution.newInteger(9));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(30, solution.newInteger(27));
    assertEquals(31, solution.newInteger(28));
    assertEquals(100, solution.newInteger(81));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    assertEquals(352, solution.newInteger(290));
    assertEquals(406, solution.newInteger(330));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    assertEquals(1331, solution.newInteger(1000));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    assertEquals(2052305618, solution.newInteger(800000000));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new InterestingSolution()
    );
  }
}