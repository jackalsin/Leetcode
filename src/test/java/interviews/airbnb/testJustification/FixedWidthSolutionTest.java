package interviews.airbnb.testJustification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/7/2019.
 */
class FixedWidthSolutionTest {
  private FixedWidthSolution solution;

  @BeforeEach
  void setUp() {
    solution = new FixedWidthSolution();
  }

  @Test
  void testOnlineCase1() {
    final List<String> input = List.of(
        "first word",
        "my second sentence",
        "now it's third"
    ), expected = List.of(
        "+--------------+",
        "|first word    |",
        "+--------------+",
        "|my second     |",
        "|sentence      |",
        "+--------------+",
        "|now it's third|",
        "+--------------+"
    ), actual = solution.format(input, 14);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCaseEndWithSpace() {
    final List<String> input = List.of(
        "now it's third "
    ), expected = List.of(
        "+---------------+",
        "|now it's third |",
        "+---------------+"
    ), actual = solution.format(input, 15);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCaseEndWithSpace2Line() {
    final List<String> input = List.of(
        "now it's third "
    ), expected = List.of(
        "+--------------+",
        "|now it's third|",
        "|              |",
        "+--------------+"
    ), actual = solution.format(input, 14);
    assertEquals(expected, actual);
  }
}