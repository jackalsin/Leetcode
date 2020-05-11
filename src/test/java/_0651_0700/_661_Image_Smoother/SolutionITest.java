package _0651_0700._661_Image_Smoother;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {1, 1, 1},
        {1, 0, 1},
        {1, 1, 1}
    }, expected = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
    }, actual = solution.imageSmoother(input);
    assertTrue(Arrays.deepEquals(actual, expected));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}