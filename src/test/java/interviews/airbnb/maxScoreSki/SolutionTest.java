package interviews.airbnb.maxScoreSki;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String[][] edges = {
        {"A", "B", "2"},
        {"A", "C", "3"},
        {"B", "D", "5"},
        {"B", "E", "6"},
        {"C", "E", "4"},
        {"C", "F", "4"},
        {"D", "H", "7"},
        {"E", "H", "6"},
        {"F", "J", "3"},
        {"H", "I", "1"},
        {"H", "J", "2"},
    };
    final String[][] nodeScores = {
        {"A", "5"},
        {"B", "7"},
        {"C", "6"},
        {"D", "2"},
        {"E", "4"},
        {"F", "7"},
        {"H", "7"},
        {"I", "3"},
        {"J", "2"},
    };

    assertEquals(67, solution.maxScore(edges, nodeScores, "A"));
  }
}