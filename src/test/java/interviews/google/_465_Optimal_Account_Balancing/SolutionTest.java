package interviews.google._465_Optimal_Account_Balancing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/15/2018.
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
  public void testOnlineCase1(Solution solution) {
    final int[][] trans = {{0, 1, 10}, {2, 0, 5}};
    assertEquals(2, solution.minTransfers(trans));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testFailedCase2(Solution solution) {
    final int[][] trans = {{1, 5, 8}, {8, 9, 8}, {2, 3, 9}, {4, 3, 1}};
    assertEquals(4, solution.minTransfers(trans));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase2(Solution solution) {
    final int[][] trans = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
    assertEquals(1, solution.minTransfers(trans));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testFailedCase1(Solution solution) {
    final int[][] trans = {{2, 0, 5}, {3, 4, 4}};
    assertEquals(2, solution.minTransfers(trans));
  }

}
