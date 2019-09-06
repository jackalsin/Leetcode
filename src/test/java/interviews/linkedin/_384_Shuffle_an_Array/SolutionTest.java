package interviews.linkedin._384_Shuffle_an_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
class SolutionTest {
  private static final int[] INPUT = {1, 2, 3};
  private static final int TOTAL = 100_000_000;
  //  private static final int TOTAL = 1_000_000_000;
  private static final double BIAS = 1e-3;

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final Map<List<Integer>, Double> listCounts = new HashMap<>();
    for (int i = 0; i < TOTAL; ++i) {
      final List<Integer> key = Arrays.stream(solution.shuffle())
          .boxed().collect(Collectors.toList());
      listCounts.put(key, listCounts.getOrDefault(key, 0d) + 1);
    }
    final double expected = 1d / 6;
    for (final Map.Entry<List<Integer>, Double> e : listCounts.entrySet()) {
      final double actual = e.getValue() / TOTAL;
      assertEquals(expected, actual, BIAS);
    }
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(INPUT),
        new SolutionII(INPUT),
        new SolutionIII(INPUT)
    );
  }
}