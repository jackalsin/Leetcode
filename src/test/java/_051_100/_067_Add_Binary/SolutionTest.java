package _051_100._067_Add_Binary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/26/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithNoCarry() {
    String a = "1";
    String b = "1";
    assertEquals("10", solution.addBinary(a, b));
  }

  @Test
  void testWithCarry() {
    String a = "1";
    String b = "0";
    assertEquals("1", solution.addBinary(a, b));
  }

  @Test
  void testWithDifferentLens() {
    String a = "11";
    String b = "1";
    assertEquals("100", solution.addBinary(a, b));
  }
}