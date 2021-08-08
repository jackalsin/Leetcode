package linkedin._056_Merge_Intervals;

import definition.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(Solution solution) {
    final List<Interval> result = Arrays.asList(new Interval(1, 4), new Interval(2, 3));
    final List<Interval> expected = List.of(new Interval(1, 4));
    assertEquals(expected, solution.merge(result));
  }


}
