package _0951_1000._984_String_Without_AAA_or_BBB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    System.out.println(solution.strWithout3a3b(1, 2));
  }

  @Test
  void testOnlineCase2() {
    System.out.println(solution.strWithout3a3b(4, 1));
  }

  @Test
  void testOnlineCase3() {
    System.out.println(solution.strWithout3a3b(2, 5));
  }
}