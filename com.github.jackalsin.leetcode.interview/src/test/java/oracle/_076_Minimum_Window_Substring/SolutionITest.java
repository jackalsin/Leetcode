package oracle._076_Minimum_Window_Substring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase(Solution solution) {
    assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
  }


  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}