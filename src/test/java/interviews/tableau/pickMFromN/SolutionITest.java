package interviews.tableau.pickMFromN;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
class SolutionITest {
  private static final double BIAS = 1E-3;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int start = 10, end = 20, picked = 5, totalToss = 10_000_000, totalOccur = totalToss * picked;
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int i = 0; i < totalToss; ++i) {
      final List<Integer> result = solution.getMFromRange(start, end, picked);
      result.forEach(x -> counts.put(x, counts.getOrDefault(x, 0) + 1));
    }
    final double expected = (double) totalToss * picked / (end - start) / totalOccur;
    for (final Map.Entry<Integer, Integer> e : counts.entrySet()) {
      assertEquals(expected, 1d * e.getValue() / totalOccur, BIAS);
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}