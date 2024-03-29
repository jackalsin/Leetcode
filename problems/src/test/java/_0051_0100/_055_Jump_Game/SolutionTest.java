package _0051_0100._055_Jump_Game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/20/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOnlineCase1(Solution solution) {
    assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOnlineCase2(Solution solution) {
    assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOnlineCase3(Solution solution) {
    assertTrue(solution.canJump(new int[]{1, 2, 3}));
  }
}