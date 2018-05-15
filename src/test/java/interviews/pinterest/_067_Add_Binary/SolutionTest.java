package interviews.pinterest._067_Add_Binary;

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
    final String a = "11", b = "1", expected = "100";
    assertEquals(expected, solution.addBinary(a, b));
  }

  @Test
  void testOnlineCase2() {
    final String a = "1010", b = "1011", expected = "10101";
    assertEquals(expected, solution.addBinary(a, b));
  }
}