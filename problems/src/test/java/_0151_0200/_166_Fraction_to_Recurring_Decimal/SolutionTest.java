package _0151_0200._166_Fraction_to_Recurring_Decimal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 7/29/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testZero(Solution solution) {
    assertEquals("0", solution.fractionToDecimal(0, 1));
    assertEquals("0", solution.fractionToDecimal(0, -1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOverflowNumPositive(Solution solution) {
    assertEquals(String.valueOf(Integer.MAX_VALUE),
        solution.fractionToDecimal(Integer.MAX_VALUE, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testDecimal(Solution solution) {
    assertEquals("1.(6)", solution.fractionToDecimal(10, 6));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testDecimalNeg(Solution solution) {
    assertEquals("-1.(6)", solution.fractionToDecimal(-10, 6));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1And333(Solution solution) {
    assertEquals("0.(003)", solution.fractionToDecimal(1, 333));
  }
}
