package doordash._759_Employee_Free_Time.mutation;

import definition.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/12/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(1, 2), new Interval(5, 6)),
        List.of(new Interval(1, 3)),
        List.of(new Interval(4, 10))
    );

    final List<Interval> expected = List.of(new Interval(3, 4));
    final List<Interval> actual = solution.employeeFreeTime(input, 1, 10);
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
    final List<Interval> actual = solution.employeeFreeTime(input, 5, 9);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(7, 24), new Interval(29, 33), new Interval(45, 57), new Interval(66, 69), new Interval(94,
            99)),
        List.of(new Interval(6, 24), new Interval(43, 49), new Interval(56, 59), new Interval(61, 75),
            new Interval(80, 81)),
        List.of(new Interval(5, 16), new Interval(18, 26), new Interval(33, 36), new Interval(39, 57),
            new Interval(65, 74)),
        List.of(new Interval(9, 16), new Interval(27, 35), new Interval(40, 55), new Interval(68, 71),
            new Interval(78, 81)),
        List.of(new Interval(0, 25), new Interval(29, 31), new Interval(40, 47), new Interval(57, 87),
            new Interval(91, 94))
    );

    final List<Interval> expected = List.of(
        new Interval(26, 27), new Interval(36, 39), new Interval(87, 91)
    ), actual = solution.employeeFreeTime(input, 26, 91);
    assertEquals(expected, actual);
  }

  /**
   * End in one of available time
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(1, 2), new Interval(5, 6)),
        List.of(new Interval(5, 10)),
        List.of(new Interval(1, 3))
    );

    final List<Interval> expected = List.of(
    ), actual = solution.employeeFreeTime(input, 1, 3);
    assertEquals(expected, actual);
  }


  /**
   * Start in one of available time
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(1, 2), new Interval(5, 6)),
        List.of(new Interval(5, 10)),
        List.of(new Interval(1, 3))
    );

    final List<Interval> expected = List.of(
        new Interval(4, 5)
    ), actual = solution.employeeFreeTime(input, 4, 10);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}