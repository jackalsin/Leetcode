package interviews.airbnb.findCaseCombinationsOfAString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCaseLowerCaseExactMatch() {
    final String src = "ab";
    assertTrue(solution.matchHiddenString(src, x -> x.equals("ab")));
  }

  @Test
  void testOnlineCase1() {
    final String src = "ab";
    assertTrue(solution.matchHiddenString(src, x -> x.equals("Ab")));
  }

  @Test
  void testOnlineCase2() {
    final String src = "ab";
    assertTrue(solution.matchHiddenString(src, x -> x.equals("aB")));
  }

  @Test
  void testOnlineCase3() {
    final String src = "ab";
    assertTrue(solution.matchHiddenString(src, x -> x.equals("AB")));
  }

  @Test
  void testOnlineCase4() {
    final String src = "ab";
    assertFalse(solution.matchHiddenString(src, x -> x.equals("AC")));
  }

  @Test
  void testOnlineCase5() {
    final String src = "ab";
    assertFalse(solution.matchHiddenString(src, x -> x.equals("ABC")));
  }

}