package _0351_0400._360_Sort_Transformed_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{3, 9, 15, 33},
        solution.sortTransformedArray(input, 1, 3, 5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{-23, -5, 1, 7},
        solution.sortTransformedArray(input, -1, 3, 5));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testAEquals(Solution solution) {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{1, 3, 7, 9},
        solution.sortTransformedArray(input, 0, -1, 5));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(Solution solution) {
    final int[] input = {-4, -2, 2, 4};
    assertArrayEquals(new int[]{-7, -1, 11, 17},
        solution.sortTransformedArray(input, 0, 3, 5));
  }
}
