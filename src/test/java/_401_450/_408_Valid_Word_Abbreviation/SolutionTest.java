package _401_450._408_Valid_Word_Abbreviation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String s = "internationalization", abbr = "i12iz4n";
    assertTrue(solution.validWordAbbreviation(s, abbr));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String s = "apple", abbr = "a2e";
    assertFalse(solution.validWordAbbreviation(s, abbr));
  }

  @Test
  public void testFailedCheckBoundary() throws Exception {
    final String word = "internationalization", abbr = "i5a11o1";
    assertTrue(solution.validWordAbbreviation(word, abbr));
  }

  @Test
  public void testWordOutOfBoundary() throws Exception {
    final String word = "hi", abbr = "2i";
    assertFalse(solution.validWordAbbreviation(word, abbr));
  }

  @Test
  public void test01() throws Exception {
    final String word = "a", abbr = "01";
    assertFalse(solution.validWordAbbreviation(word, abbr));
  }

  @Test
  public void testEmptyAbbr() throws Exception {
    final String word = "a", abbr = "";
    assertFalse(solution.validWordAbbreviation(word, abbr));
  }

  @Test
  public void testEmptyBoth() throws Exception {
    final String word = "", abbr = "";
    assertTrue(solution.validWordAbbreviation(word, abbr));
  }

}
