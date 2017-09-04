package _251_300._282_Expression_Add_Operators;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "123";
    List<String> actual = solution.addOperators(input, 6);
    Set<String> expect = new HashSet<String>() {{add("1+2+3"); add("1*2*3");}};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "232";
    List<String> actual = solution.addOperators(input, 8);
    Set<String> expect = new HashSet<String>() {{add("2+3*2"); add("2*3+2");}};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }
  @Test
  public void testOnlineCase3() throws Exception {
    final String input = "105";
    List<String> actual = solution.addOperators(input, 5);
    Set<String> expect = new HashSet<String>() {{add("1*0+5"); add("10-5");}};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }
  @Test
  public void testOnlineCase4() throws Exception {
    final String input = "00";
    List<String> actual = solution.addOperators(input, 0);
    Set<String> expect = new HashSet<String>() {{add("0+0"); add("0-0"); add("0*0");}};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }
  @Test
  public void testOnlineCase5() throws Exception {
    final String input = "3456237490";
    List<String> actual = solution.addOperators(input, 9191);
    Set<String> expect = new HashSet<String>();
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }
}
