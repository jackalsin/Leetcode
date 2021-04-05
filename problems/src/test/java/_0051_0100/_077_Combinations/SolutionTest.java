package _0051_0100._077_Combinations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 5/12/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith4And2(Solution solution) {
    Set<List<Integer>> expected = new HashSet<>();
    expected.add(Arrays.asList(1, 2));
    expected.add(Arrays.asList(1, 3));
    expected.add(Arrays.asList(1, 4));
    expected.add(Arrays.asList(2, 3));
    expected.add(Arrays.asList(2, 4));
    expected.add(Arrays.asList(3, 4));
    assertEquals(expected, new HashSet<>(solution.combine(4, 2)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBenchMark(Solution solution) {
    final int times = 10_000;
    for (int i = 0; i < times; i++) {
      testWith4And2(solution);
    }
    long startTime = System.nanoTime();
    for (int i = 0; i < times; i++) {
      testWith4And2(solution);
    }
    long endTime = System.nanoTime();
    System.out.println("Copy: " + (endTime - startTime) / times / 1e3);
  }
}