package uber._093_Restore_IP_Addresses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    final String input = "25525511135";
    final List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
    assertEquals(new HashSet<>(expected), new HashSet<>(solution.restoreIpAddresses(input)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testLeadingZero(Solution solution) {
    final String input = "010010";
    final List<String> expected = Arrays.asList("0.10.0.10", "0.100.1.0");
    assertEquals(new HashSet<>(expected), new HashSet<>(solution.restoreIpAddresses(input)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testTLE(Solution solution) {
    StringBuilder inputSb = new StringBuilder();
    for (int i = 0; i < 10_000; i++) {
      inputSb.append('1');
    }
    assertEquals(new HashSet<>(), new HashSet<>(solution.restoreIpAddresses(inputSb.toString())));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DfsSolution(),
        new CombinationSolution()
    );
  }
}