package _501_550._544_Output_Contest_Matches;

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
  public void test2() {
    assertEquals("(1,2)", solution.findContestMatch(2));
  }

  @Test
  public void test4() {
    assertEquals("((1,4),(2,3))", solution.findContestMatch(4));
  }

  @Test
  public void test8() {
    assertEquals("(((1,8),(4,5)),((2,7),(3,6)))", solution.findContestMatch(8));
  }
}