package amazon.reorderedTheLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final List<String> logLines = List.of("a1 9 2 3 1",
        "g1 Act car", "zo4 4 7", "ab1 off KEY dog", "a8 act zoo"
    );

    final List<String> expected = List.of(
        "g1 Act car", "a8 act zoo", "ab1 off KEY dog", "a1 9 2 3 1", "zo4 4 7"
    );

    assertEquals(expected, solution.reorderLines(5, logLines));
  }
}
