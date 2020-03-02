package _0551_0600._582_Kill_Process;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final List<Integer> pid = List.of(1, 3, 10, 5),
        ppid = List.of(3, 0, 5, 3);
    final int kill = 5;
    final List<Integer> expected = List.of(5, 10);
    assertEquals(expected, solution.killProcess(pid, ppid, kill));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}