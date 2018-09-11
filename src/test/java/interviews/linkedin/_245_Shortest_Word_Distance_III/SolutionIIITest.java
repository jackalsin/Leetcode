package interviews.linkedin._245_Shortest_Word_Distance_III;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionIII();
  }

  @Test
  void testMakesAndMakes() throws Exception {
    final String[] input = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(1, solution.shortestWordDistance(input, "makes", "coding"));
    assertEquals(3, solution.shortestWordDistance(input, "makes", "makes"));
  }
}