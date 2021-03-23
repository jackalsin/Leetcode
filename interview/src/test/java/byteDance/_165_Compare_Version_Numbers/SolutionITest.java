package byteDance._165_Compare_Version_Numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/22/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testEqualNormal(Solution solution) {
    assertEquals(0, solution.compareVersion("0", "0"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testEqualDigitsDiff(Solution solution) {
    assertEquals(0, solution.compareVersion("0.0.0", "0"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testGreaterWithTheSameDigits(Solution solution) {
    assertEquals(1, solution.compareVersion("1.11.2", "1.11.1"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testGreaterWithDiffDigit(Solution solution) {
    assertEquals(1, solution.compareVersion("1.11.2", "1.11"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testGreaterWithDiffDigits(Solution solution) {
    assertEquals(1, solution.compareVersion("1.11.2", "1"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}