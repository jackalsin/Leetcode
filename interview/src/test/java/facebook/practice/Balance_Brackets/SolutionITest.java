package facebook.practice.Balance_Brackets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/3/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    String s_2 = "{{[[(())]]}}";
    boolean expected_2 = true;
    boolean output_2 = solution.isBalanced(s_2);
    assertEquals(expected_2, output_2);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    String s_2 = "{{[[(())]]}}";
    boolean expected_2 = true;
    boolean output_2 = solution.isBalanced(s_2);
    assertEquals(expected_2, output_2);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}