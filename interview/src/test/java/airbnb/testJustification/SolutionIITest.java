package airbnb.testJustification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionII();
  }

  // test with the longest word width
  @Test
  void testOnlineCase1() {
    final List<String> input = List.of(
        "first word",
        "my second sentence",
        "now it's third"
    ), expected = List.of(
        "+------------------+",
        "|first word        |",
        "+------------------+",
        "|my second sentence|",
        "+------------------+",
        "|now it's third    |",
        "+------------------+"
    ), actual = solution.format(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final List<String> input = List.of(
    ), expected = List.of(
        "++",
        "++"
    ), actual = solution.format(input);
    assertEquals(expected, actual);
  }

  // test with the fixed width
  @Test
  void testOnlineCase3() {
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