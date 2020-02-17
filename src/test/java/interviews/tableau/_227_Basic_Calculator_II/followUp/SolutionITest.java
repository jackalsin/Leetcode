package interviews.tableau._227_Basic_Calculator_II.followUp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final List<String> input = List.of("1+2", "3*4+5", "A0*2", "A1+6", "A2+A3"),
        expected = List.of("3", "17", "6(3*2)", "23(17+6)", "29(6+23)"),
        actual = solution.calculate(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}