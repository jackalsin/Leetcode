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
    solution = new Solution();
  }

  @Test
  public void testZero() throws Exception {
    assertEquals("Zero", solution.numberToWords(0));
  }

  @Test
  public void testOne() throws Exception {
    assertEquals("One", solution.numberToWords(1));
  }

  @Test
  public void test27() throws Exception {
    assertEquals("Twenty Seven", solution.numberToWords(27));
  }
  @Test
  public void test127() throws Exception {
    assertEquals("One Hundred Twenty Seven", solution.numberToWords(127));
  }

  @Test
  public void test1227() throws Exception {
    assertEquals("One Thousand Two Hundred Twenty Seven", solution.numberToWords(1227));
  }

  @Test
  public void test1234567() throws Exception {
    assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
        solution.numberToWords(1234567));
  }

  @Test
  public void testMillion() throws Exception {
    assertEquals("One Million", solution.numberToWords(1_000_000));
  }

  @Test
  public void testMillion2Hundred() throws Exception {
    assertEquals("One Million Two Hundred", solution.numberToWords(1_000_200));
  }
}
