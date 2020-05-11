package interviews.google._248_Strobogrammatic_Number_III;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testZero(Solution solution) {
    assertEquals(1, solution.strobogrammaticInRange("0", "0"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testLeadingZero(Solution solution) {
    assertEquals(3, solution.strobogrammaticInRange("90", "111"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testLeading50And100(Solution solution) {
    assertEquals(3, solution.strobogrammaticInRange("50", "100"));
  }

  @Test
  void testOnlineCase1() {
    assertEquals(-1, SolutionI.isInRange("90", "111", "89"));
    assertEquals(0, SolutionI.isInRange("90", "111", "90"));
    assertEquals(0, SolutionI.isInRange("90", "111", "111"));
    assertEquals(1, SolutionI.isInRange("90", "111", "112"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}