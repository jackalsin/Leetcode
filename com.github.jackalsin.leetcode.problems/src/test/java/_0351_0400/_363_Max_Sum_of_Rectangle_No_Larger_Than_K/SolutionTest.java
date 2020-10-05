package _0351_0400._363_Max_Sum_of_Rectangle_No_Larger_Than_K;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 11/6/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) throws Exception {
    final int[][] matrix = new int[][]{
        {1, 0, 1},
        {0, -2, 3}
    };
    assertEquals(2, solution.maxSumSubmatrix(matrix, 2));
  }
}
