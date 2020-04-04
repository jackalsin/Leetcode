package _0251_0300._283_Move_Zeroes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnline(Solution solution) {
    final int[] input = new int[]{0, 1, 0, 3, 12};
    final int[] expected = new int[]{1, 3, 12, 0, 0};
    solution.moveZeroes(input);
    assertArrayEquals(expected, input);
  }
}
