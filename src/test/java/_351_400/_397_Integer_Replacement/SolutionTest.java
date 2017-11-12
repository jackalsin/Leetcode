package _351_400._397_Integer_Replacement;

import org.junit.Before;
import org.junit.Test;

import java.net.Socket;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 11/11/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(3, solution.integerReplacement(8));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals(4, solution.integerReplacement(7));
  }

  @Test
  public void testFailedOn1234() throws Exception {
    System.out.println(Integer.toBinaryString(1234));
    assertEquals(14, solution.integerReplacement(1234));
  }

  @Test
  public void testOn3() throws Exception {
    assertEquals(2, solution.integerReplacement(3));
  }

  @Test
  public void testOn6() throws Exception {
    assertEquals(2, solution.integerReplacement(3));
  }
}
