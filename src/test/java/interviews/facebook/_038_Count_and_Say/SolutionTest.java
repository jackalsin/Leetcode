package interviews.facebook._038_Count_and_Say;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWith1() {
    assertEquals("1", solution.countAndSay(1));
  }

  @Test
  void testWith2() {
    assertEquals("11", solution.countAndSay(2));
  }

  @Test
  void testWith13() {
    assertEquals("11131221133112132113212221", solution.countAndSay(11));
  }

}