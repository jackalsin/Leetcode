package interviews.microsoft._258_Add_Digits;

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
  void test38() {
    assertEquals(2, solution.addDigits(38));
  }

  @Test
  void test1() {
    assertEquals(1, solution.addDigits(1));
  }

  @Test
  void test0() {
    assertEquals(0, solution.addDigits(0));
  }

}