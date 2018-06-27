package interviews.linkedin._245_Shortest_Word_Distance_III;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {

  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(1, solution.shortestWordDistance(words, "makes", "coding"));
  }

  @Test
  void testOnlineCase2() {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    assertEquals(3, solution.shortestWordDistance(words, "makes", "makes"));
  }

}