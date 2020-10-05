package airbnb.testJustification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/7/2019.
 */
class LongestLengthSolutionTest {
  private LongestLengthSolution solution;

  @BeforeEach
  void setUp() {
    solution = new LongestLengthSolution();
  }

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
}