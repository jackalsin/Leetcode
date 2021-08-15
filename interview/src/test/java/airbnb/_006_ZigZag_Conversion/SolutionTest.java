package airbnb._006_ZigZag_Conversion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private static final String STR1 = "PAYPALISHIRING";

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testConvertWithEmptyString(Solution solution) {
    assertEquals("", solution.convert("", 1));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void convert1(Solution solution) {
    assertEquals(STR1, solution.convert(STR1, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void convert2(Solution solution) {
    assertEquals("PYAIHRNAPLSIIG", solution.convert(STR1, 2));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void convert3(Solution solution) {
    assertEquals("PAHNAPLSIIGYIR", solution.convert(STR1, 3));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void convert4(Solution solution) {
    assertEquals("PINALSIGYAHRPI", solution.convert(STR1, 4));
  }
}