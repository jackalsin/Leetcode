package _0201_0250._248_Strobogrammatic_Number_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/24/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

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
}
