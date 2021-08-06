package linkedin._020_Valid_Parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
