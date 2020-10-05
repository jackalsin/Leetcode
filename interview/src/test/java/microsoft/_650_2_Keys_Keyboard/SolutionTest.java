package microsoft._650_2_Keys_Keyboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  void test1() throws Exception {
    assertEquals(0, solution.minSteps(1));
  }

  @Test
  void test2() throws Exception {
    assertEquals(2, solution.minSteps(2));
  }

  @Test
  void test3() throws Exception {
    assertEquals(3, solution.minSteps(3));
  }

  /**
   * Do notice, copy also counts as operations
   */
  @Test
  void test4() throws Exception {
    assertEquals(4, solution.minSteps(4));
  }

  @Test
  void test5() throws Exception {
    assertEquals(5, solution.minSteps(5));
  }

  @Test
  void test6() throws Exception {
    assertEquals(5, solution.minSteps(6));
  }

  @Test
  void test7() throws Exception {
    assertEquals(7, solution.minSteps(7));
  }

  @Test
  void test144() throws Exception {
    assertEquals(14, solution.minSteps(144));
  }

}