package _0451_0500._476_Number_Complement;

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
    assertEquals(2, solution.findComplement(5));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(0, solution.findComplement(1));
  }
}