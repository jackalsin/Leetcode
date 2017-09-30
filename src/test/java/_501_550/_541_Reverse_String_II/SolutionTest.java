package _501_550._541_Reverse_String_II;

import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/30/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String s = "abcdefg";
    assertEquals("bacdfeg", solution.reverseStr(s, 2));
  }

}
