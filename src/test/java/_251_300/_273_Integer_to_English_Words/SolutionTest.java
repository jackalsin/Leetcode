package _251_300._273_Integer_to_English_Words;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new IntuitiveSolution();
  }

  @Test
  public void testZero() {
    assertEquals("Zero", solution.numberToWords(0));
  }

  @Test
  public void testOne() {
    assertEquals("One", solution.numberToWords(1));
  }

  @Test
  public void test27() {
    assertEquals("Twenty Seven", solution.numberToWords(27));
  }
  @Test
  public void test127() {
    assertEquals("One Hundred Twenty Seven", solution.numberToWords(127));
  }

  @Test
  public void test1227() {
    assertEquals("One Thousand Two Hundred Twenty Seven", solution.numberToWords(1227));
  }

  @Test
  public void test1234567() {
    assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
        solution.numberToWords(1234567));
  }

  @Test
  public void testMillion() {
    assertEquals("One Million", solution.numberToWords(1_000_000));
  }

  @Test
  public void testMillion2Hundred() {
    assertEquals("One Million Two Hundred", solution.numberToWords(1_000_200));
  }
}
