package microsoft._651_4_Keys_Keyboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    assertEquals(3, solution.maxA(3));
  }

  @Test
  void testOnlineCase2() throws Exception {
    assertEquals(9, solution.maxA(7));
  }

  @Test
  void test5() throws Exception {
    assertEquals(5, solution.maxA(5));
  }

  @Test
  void test4() throws Exception {
    assertEquals(6, solution.maxA(6));
  }
}