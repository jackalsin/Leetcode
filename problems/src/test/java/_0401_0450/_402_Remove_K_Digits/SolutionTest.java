package _0401_0450._402_Remove_K_Digits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnline1432219(Solution solution) {
    assertEquals("1219", solution.removeKdigits("1432219", 3));
  }

  /**
   * Leading Zero will be tested.
   *
   * @throws Exception
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnline10200(Solution solution) {
    assertEquals("200", solution.removeKdigits("10200", 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnline10(Solution solution) {
    assertEquals("0", solution.removeKdigits("10", 2));
//    assertEquals("0", solution.sampleSolution("9", 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedOn9(Solution solution) {
    assertEquals("0", solution.removeKdigits("9", 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedOn112(Solution solution) {
    assertEquals("11", solution.removeKdigits("112", 1));
  }
}
