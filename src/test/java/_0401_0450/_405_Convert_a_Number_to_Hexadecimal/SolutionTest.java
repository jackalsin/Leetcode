package _0401_0450._405_Convert_a_Number_to_Hexadecimal;

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
    assertEquals("1a", solution.toHex(26));
  }

  @Test
  void testOnlineCase2() {
    assertEquals("ffffffff", solution.toHex(-1));
  }

  @Test
  void testFailedOn0() {
    assertEquals("0", solution.toHex(0));
  }
}