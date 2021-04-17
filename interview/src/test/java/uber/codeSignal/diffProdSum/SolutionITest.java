package uber.codeSignal.diffProdSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/12/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(0, solution.diff(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase123456(Solution solution) {
    // 720 - 7 * 3
    assertEquals(699, solution.diff(123456));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}