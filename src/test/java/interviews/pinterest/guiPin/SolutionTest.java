package interviews.pinterest.guiPin;

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
    final int[] heights = {100, 300, 400};
    final int width = 200,
        numColumns = 2,
        padding = 0;

    List<List<Integer>> expected = List.of(
        List.of(0, 0),
        List.of(100, 0),
        List.of(0, 100)
    );

    assertEquals(expected, solution.getPinList(heights, width, numColumns, padding));
  }
}