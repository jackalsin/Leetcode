package airbnb._591_Tag_Validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/1/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(Solution solution) {
    final String input = "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testTLESolution(Solution solution) {
    final String input = "<A><![CDATA[</A>]]123></A>";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final String input = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
    assertTrue(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final String input = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>";
    assertTrue(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final String input = "<A>  <B> </A>   </B>";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase4(Solution solution) {
    final String input = "<DIV>  div tag is not closed  <DIV>";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase5(Solution solution) {
    final String input = "<DIV>  unmatched <  </DIV>";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase6(Solution solution) {
    final String input = "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase7(Solution solution) {
    final String input = "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase8(Solution solution) {
    final String input = "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase2(Solution solution) {
    final String input = "<DIV>  a  </DIV>3";
    assertFalse(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase3(Solution solution) {
    final String input = "<A><A>456</A>  <A> 123  !!  <![CDATA[]]>  123 </A>   <A>123</A></A>";
    assertTrue(solution.isValid(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase4(Solution solution) {
    final String input = "<AAAAAAAAAA></AAAAAAAAAA>";
    assertFalse(solution.isValid(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}