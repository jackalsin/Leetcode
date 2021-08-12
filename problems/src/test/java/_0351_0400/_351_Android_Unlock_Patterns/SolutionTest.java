package _0351_0400._351_Android_Unlock_Patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/8/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCaseM1N1(Solution solution) {
    assertEquals(9, solution.numberOfPatterns(1, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCaseM1N2(Solution solution) {
    assertEquals(65, solution.numberOfPatterns(1, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCaseM1N3(Solution solution) {
    Assertions.assertEquals(385, solution.numberOfPatterns(1, 3));
  }

}
