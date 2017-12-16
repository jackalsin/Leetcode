package _501_550._526_Beautiful_Arrangement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new DfsSolution();
    solution = new ReverseSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(1, solution.countArrangement(1));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals(2, solution.countArrangement(2));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    assertEquals(3, solution.countArrangement(3));
  }


}