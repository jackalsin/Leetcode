package interviews.tableau._338_Counting_Bits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase(Solution solution) {
    final int[] expected = {0, 1, 1, 2, 1, 2};
    assertArrayEquals(expected, solution.countBits(5));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase2(Solution solution) {
    final int[] expected = {0, 1, 1, 2, 1};
    assertArrayEquals(expected, solution.countBits(4));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}