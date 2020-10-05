package microsoft._591_Tag_Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testFailedCase1() throws Exception {
    final String input = "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testTLESolution() throws Exception {
    final String input = "<A><![CDATA[</A>]]123></A>";
    assertFalse(solution.isValid(input));
  }


  @Test
  void testOnlineCase1() throws Exception {
    final String input = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
    assertTrue(solution.isValid(input));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String input = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>";
    assertTrue(solution.isValid(input));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final String input = "<A>  <B> </A>   </B>";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testOnlineCase4() throws Exception {
    final String input = "<DIV>  div tag is not closed  <DIV>";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testOnlineCase5() throws Exception {
    final String input = "<DIV>  unmatched <  </DIV>";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testOnlineCase6() throws Exception {
    final String input = "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testOnlineCase7() throws Exception {
    final String input = "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testOnlineCase8() throws Exception {
    final String input = "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testFailedCase2() throws Exception {
    final String input = "<A";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testFailedCase3() throws Exception {
    final String input = "<DIV><></></DIV>";
    assertFalse(solution.isValid(input));
  }

  @Test
  void testFailedCase4() throws Exception {
    final String input = "<A></A>>";
    assertFalse(solution.isValid(input));
  }

}