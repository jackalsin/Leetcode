package interviews.linkedin._636_Exclusive_Time_of_Functions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int n = 2;
    final List<String> logs = List.of(
        "0:start:0",
        "1:start:2",
        "1:end:5",
        "0:end:6");

    final int[] output = {3, 4}, actual = solution.exclusiveTime(n, logs);
    assertArrayEquals(output, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }
}