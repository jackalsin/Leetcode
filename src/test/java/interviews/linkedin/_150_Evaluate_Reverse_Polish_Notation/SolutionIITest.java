package interviews.linkedin._150_Evaluate_Reverse_Polish_Notation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/6/2019
 */
class SolutionIITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) throws Exception {
    final String[] input = new String[]{};
    assertEquals(0, solution.evalRPN(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) throws Exception {
    final String[] input = new String[]{"2", "1", "+", "3", "*"};
    assertEquals(9, solution.evalRPN(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) throws Exception {
    final String[] input = new String[]{"4", "13", "5", "/", "+"};
    assertEquals(6, solution.evalRPN(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(new SolutionI(), new SolutionII());
  }
}