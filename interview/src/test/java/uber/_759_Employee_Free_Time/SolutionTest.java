package uber._759_Employee_Free_Time;

import definition.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(1, 2), new Interval(5, 6)),
        List.of(new Interval(1, 3)),
        List.of(new Interval(4, 10))
    );

    final List<Interval> expected = List.of(new Interval(3, 4));
    final List<Interval> actual = solution.employeeFreeTime(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(1, 3), new Interval(6, 7)),
        List.of(new Interval(2, 4)),
        List.of(new Interval(2, 5), new Interval(9, 12))
    );

    final List<Interval> expected = List.of(
        new Interval(5, 6), new Interval(7, 9)
    );
    final List<Interval> actual = solution.employeeFreeTime(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

}