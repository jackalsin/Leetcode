package airbnb.lowestCommonAncestors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author jacka
 * @version 1.0 on 2/18/2019.
 */
class SolutionIITest {
  private Solution solution;

  @Test
  void testOnlineCase1() {
    final String[][] words = {
        {"earth", "america"},
        {"america", "south america", "north america"},
        {"north america", "canada", "us"},
        {"canada", "ontario", "quebec", "calgary"},
        {"us", "california"}
    };
    solution = new SolutionII(words);

    assertEquals("north america", solution.commonAncestors("us", "canada"));
    assertEquals("north america", solution.commonAncestors("california", "canada"));
    assertEquals("north america", solution.commonAncestors("california", "ontario"));
  }

  @Test
  void testSelfCycle() {
    final String[][] words = {
        {"A", "B", "C"},
        {"B", "D", "E", "B"}
    };
    solution = new SolutionII(words);

    assertNull(solution.commonAncestors("B", "A"));
    assertEquals("B", solution.commonAncestors("B", "B"));
    assertNull(solution.commonAncestors("B", "D"));
    assertNull(solution.commonAncestors("D", "B"));
    assertNull(solution.commonAncestors("B", "E"));
    assertNull(solution.commonAncestors("E", "B"));
  }

  @Test
  void testMutualCycle() {
    final String[][] words = {
        {"A", "B", "C"},
        {"B", "D", "A"}
    };
    solution = new SolutionII(words);
    assertNull(solution.commonAncestors("B", "A"));
    assertNull(solution.commonAncestors("A", "B"));
    assertEquals("B", solution.commonAncestors("B", "D"));

  }


}