package _001_100._010_Regular_Expression_Matching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2017/1/17.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void isMatchWithEmptyString() throws Exception {
    assertTrue(solution.isMatch("", ""));
  }

  @Test
  public void isMatchWithSameString() throws Exception {
    assertTrue(solution.isMatch("abc", "abc"));
  }

  @Test
  public void isMatchWithAsteriskZeroLength() throws Exception {
    assertTrue(solution.isMatch("abc", "a*bc"));
  }

  @Test
  public void isMatchWithAsteriskMoreThanOneLength() throws Exception {
    assertTrue(solution.isMatch("aaabc", "a*bc"));
  }

  @Test
  public void isMatchWithDot() throws Exception {
    assertTrue(solution.isMatch("aabc", ".*bc"));
  }

  @Test
  public void isMatchWithSingleDot() throws Exception {
    assertTrue(solution.isMatch("aebc", "a.bc"));
  }

  @Test
  public void isMatchCaseOne() throws Exception {
    assertTrue(solution.isMatch("aaa", "ab*ac*a"));

  }

  @Test
  public void isMatchCaseTwo() throws Exception {
    assertTrue(solution.isMatch("aaa", "ab*a*c*a"));
  }
}