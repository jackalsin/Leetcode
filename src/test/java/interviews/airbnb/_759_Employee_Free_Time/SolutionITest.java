package interviews.airbnb._759_Employee_Free_Time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;
import utils.TwoDimensionArray;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
class SolutionITest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(1, 2), new Interval(5, 6)),
        List.of(new Interval(1, 3)),
        List.of(new Interval(4, 10))
    );

    final List<Interval> expected = List.of(new Interval(3, 4));
    final List<Interval> actual = solution.employeeFreeTime(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
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

  @Test
  void testFailedCase1() {
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
    ), actual = solution.employeeFreeTime(input);
    assertEquals(expected, actual);
  }

  // test array method
  @Test
  void testOnlineCaseArray1() {
    final int[][][] input = {
        {{1, 2}, {5, 6}},
        {{1, 3}},
        {{4, 10}}
    };

    final int[][] expected = {{3, 4}};
    final int[][] actual = solution.employeeFreeTime(input);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

  @Test
  void testOnlineCaseArray2() {
    final int[][][] input = {
        {{1, 3}, {6, 7}},
        {{2, 4}},
        {{2, 5}, {9, 12}}
    };

    final int[][] expected = {{5, 6}, {7, 9}};
    final int[][] actual = solution.employeeFreeTime(input);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

  @Test
  void testFailedCaseArray1() {
    final int[][][] input = {
        {{7, 24}, {29, 33}, {45, 57}, {66, 69}, {94, 99}},
        {{6, 24}, {43, 49}, {56, 59}, {61, 75}, {80, 81}},
        {{5, 16}, {18, 26}, {33, 36}, {39, 57}, {65, 74}},
        {{9, 16}, {27, 35}, {40, 55}, {68, 71}, {78, 81}},
        {{0, 25}, {29, 31}, {40, 47}, {57, 87}, {91, 94}},
    };

    final int[][] expected = {
        {26, 27}, {36, 39}, {87, 91}
    }, actual = solution.employeeFreeTime(input);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }
}