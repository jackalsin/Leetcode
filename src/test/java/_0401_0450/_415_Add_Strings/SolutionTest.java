package _0401_0450._415_Add_Strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals("0", solution.addStrings("0", "0"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals("10", solution.addStrings("1", "9"));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    assertEquals("77", solution.addStrings("33", "44"));
  }

  @Test
  public void testOnlineCase4() throws Exception {
    assertEquals("114", solution.addStrings("76", "38"));
  }

}