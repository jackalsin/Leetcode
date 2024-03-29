package _0251_0300._289_Game_of_Life;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/5/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnline1(Solution solution) {
    final int[][] input = {{1, 1}, {1, 0}};
    solution.gameOfLife(input);
    final int[][] expected = {{1, 1}, {1, 1}};
    assertTrue(Arrays.deepEquals(expected, input));
  }

}
