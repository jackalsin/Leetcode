package microsoft._772_Basic_Calculator_III;

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
  void testOnlineCase1() {
    final String input = "1 + 1";
    assertEquals(2, solution.calculate(input)); // = 2
  }

  @Test
  void testOnlineCase2() {
    final String input = " 6-4 / 2 ";
    assertEquals(4, solution.calculate(input)); // = 2
  }

  @Test
  void testOnlineCase3() {
    final String input = "2*(5+5*2)/3+(6/2+8)";
    assertEquals(21, solution.calculate(input)); // = 2
  }

  @Test
  void testOnlineCase4() {
    final String input = "(2+6* 3+5- (3*14/7+2)*5)+3";
    assertEquals(-12, solution.calculate(input)); // = 2
  }
}