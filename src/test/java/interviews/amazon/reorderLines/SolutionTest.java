package interviews.amazon.reorderLines;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testCase() {
    final List<String> logFile = List.of(
        "#a",
        "#abc",
        "#de",
        "#098",
        "\"098"
    );

    final List<String> expected = List.of("\"098", "#098", "#a", "#abc", "#de");
    final List<String> actual = solution.reorderLines(logFile.size(), logFile);
    assertEquals(expected, actual);
  }

}