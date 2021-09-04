package airbnb._755_Pour_Water;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeetcodeSolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(LeetcodeSolution solution) {
    final int[] input = {2, 1, 1, 2, 1, 2, 2},
        expect = {2, 2, 2, 3, 2, 2, 2},
        actual = solution.pourWater(input, 4, 3);
    assertArrayEquals(expect, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(LeetcodeSolution solution) {
    final int[] input = {1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1},
        expect = {4, 4, 4, 4, 3, 3, 3, 3, 3, 4, 3, 2, 1},
        actual = solution.pourWater(input, 10, 2);
    assertArrayEquals(expect, actual, Arrays.toString(actual));
  }

  static Stream<LeetcodeSolution> solutionStream() {
    return Stream.of(
        new LeetcodeSolutionI(),
        new LeetcodeSolutionII()
    );
  }
}