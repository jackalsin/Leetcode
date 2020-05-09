package interviews.byteDance._351_Android_Unlock_Patterns;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCaseM1N1(Solution solution) {
    assertEquals(9, solution.numberOfPatterns(1, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCaseM1N2(Solution solution) {
    assertEquals(65, solution.numberOfPatterns(1, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCaseM1N3(Solution solution) {
    assertEquals(385, solution.numberOfPatterns(1, 3));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}