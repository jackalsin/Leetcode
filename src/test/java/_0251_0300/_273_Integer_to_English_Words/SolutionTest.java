package _0251_0300._273_Integer_to_English_Words;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new IntuitiveSolution();
  }

  @Test
  void testZero() {
    assertEquals("Zero", solution.numberToWords(0));
  }

  @Test
  void testOne() {
    assertEquals("One", solution.numberToWords(1));
  }

  @Test
  void test27() {
    assertEquals("Twenty Seven", solution.numberToWords(27));
  }

  @Test
  void test127() {
    assertEquals("One Hundred Twenty Seven", solution.numberToWords(127));
  }

  @Test
  void test1227() {
    assertEquals("One Thousand Two Hundred Twenty Seven", solution.numberToWords(1227));
  }

  @Test
  void test1234567() {
    assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
        solution.numberToWords(1234567));
  }

  @Test
  void testMillion() {
    assertEquals("One Million", solution.numberToWords(1_000_000));
  }

  @Test
  void testMillion2Hundred() {
    assertEquals("One Million Two Hundred", solution.numberToWords(1_000_200));
  }
}
