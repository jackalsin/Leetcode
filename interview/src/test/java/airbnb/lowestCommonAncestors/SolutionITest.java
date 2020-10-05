package airbnb.lowestCommonAncestors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/18/2019.
 */
class SolutionITest {
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
    solution = new SolutionI(words);

    assertEquals("north america", solution.commonAncestors("us", "canada"));
    assertEquals("north america", solution.commonAncestors("california", "canada"));
    assertEquals("north america", solution.commonAncestors("california", "ontario"));
  }
}