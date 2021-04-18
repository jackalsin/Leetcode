package uber.codeSignal.digitCounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/18/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(4, solution.digitCounts(10));
  }

  @Test
  void testGetCount() {
    final Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < 100_000; i++) {
      final String n = String.valueOf(i);
      for (char chr : n.toCharArray()) {
        final int d = chr - '0';
        count.put(d, count.getOrDefault(d, 0) + 1);
      }
      assertEquals(count.getOrDefault(0, 0), SolutionI.getCount(i, 0), "Running " + i);
      assertEquals(count.getOrDefault(2, 0), SolutionI.getCount(i, 2), "Running " + i);
      assertEquals(count.getOrDefault(4, 0), SolutionI.getCount(i, 4), "Running " + i);
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}