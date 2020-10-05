package _0551_0600._591_Tag_Validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String input = "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>";
    assertFalse(solution.isValid(input));
  }

  @Test
  public void testTLESolution() throws Exception {
    final String input = "<A><![CDATA[</A>]]123></A>";
    assertFalse(solution.isValid(input));
  }


  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
    assertTrue(solution.isValid(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>";
    assertTrue(solution.isValid(input));
  }
  @Test
  public void testOnlineCase3() throws Exception {
    final String input = "<A>  <B> </A>   </B>";
    assertFalse(solution.isValid(input));
  }
  @Test
  public void testOnlineCase4() throws Exception {
    final String input = "<DIV>  div tag is not closed  <DIV>";
    assertFalse(solution.isValid(input));
  }
  @Test
  public void testOnlineCase5() throws Exception {
    final String input = "<DIV>  unmatched <  </DIV>";
    assertFalse(solution.isValid(input));
  }

  @Test
  public void testOnlineCase6() throws Exception {
    final String input = "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>";
    assertFalse(solution.isValid(input));
  }
  @Test
  public void testOnlineCase7() throws Exception {
    final String input = "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>";
    assertFalse(solution.isValid(input));
  }
  @Test
  public void testOnlineCase8() throws Exception {
    final String input = "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>";
    assertFalse(solution.isValid(input));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final String input = "<DIV>  a  </DIV>3";
    assertFalse(solution.isValid(input));
  }

}
