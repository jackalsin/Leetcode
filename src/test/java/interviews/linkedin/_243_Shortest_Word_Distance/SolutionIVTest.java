package interviews.linkedin._243_Shortest_Word_Distance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIVTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionIV();
  }

  @Test
  void testOnlineCase1() {
    final String[] input = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(3, solution.shortestDistance(input, "coding", "practice"));
  }

  @Test
  void testOnlineCase2() {
    final String[] input = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(1, solution.shortestDistance(input, "makes", "coding"));
  }
}