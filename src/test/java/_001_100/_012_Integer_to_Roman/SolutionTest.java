package _001_100._012_Integer_to_Roman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/18.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testIntToRomanWith1() throws Exception {
    assertEquals("I", solution.intToRoman(1));
  }

  @Test
  public void testIntToRomanWith2() throws Exception {
    assertEquals("II", solution.intToRoman(2));
  }

  @Test
  public void testIntToRomanWith3() throws Exception {
    assertEquals("III", solution.intToRoman(3));
  }

  @Test
  public void testIntToRomanWith4() throws Exception {
    assertEquals("IV", solution.intToRoman(4));
  }

  @Test
  public void testIntToRomanWith5() throws Exception {
    assertEquals("V", solution.intToRoman(5));
  }

  @Test
  public void testIntToRomanWith6() throws Exception {
    assertEquals("VI", solution.intToRoman(6));
  }

  @Test
  public void testIntToRomanWith9() throws Exception {
    assertEquals("IX", solution.intToRoman(9));
  }

  @Test
  public void testIntToRomanWith10() throws Exception {
    assertEquals("X", solution.intToRoman(10));
  }

  @Test
  public void testIntToRomanWith13() throws Exception {
    assertEquals("XIII", solution.intToRoman(13));
  }

  @Test
  public void testIntToRomanWith43() throws Exception {
    assertEquals("XLIII", solution.intToRoman(43));
  }

  @Test
  public void testIntToRomanWith333() throws Exception {
    assertEquals("CCCXXXIII", solution.intToRoman(333));
  }

  @Test
  public void testIntToRomanWith433() throws Exception {
    assertEquals("CDXXXIII", solution.intToRoman(433));
  }
}