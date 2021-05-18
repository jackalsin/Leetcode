package _0701_0750._739_Daily_Temperatures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
    final int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
    assertArrayEquals(expected, solution.dailyTemperatures(temp));
  }
}
