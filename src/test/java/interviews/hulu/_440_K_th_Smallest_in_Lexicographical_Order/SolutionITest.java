package interviews.hulu._440_K_th_Smallest_in_Lexicographical_Order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertEquals(10, solution.findKthNumber(13, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    assertEquals(116, solution.findKthNumber(220, 20));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Solution solution) {
    assertEquals(2, solution.findKthNumber(2, 2));
  }

  /**
   * Overflow
   */
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    assertEquals(416126219, solution.findKthNumber(681692778, 351251360));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}