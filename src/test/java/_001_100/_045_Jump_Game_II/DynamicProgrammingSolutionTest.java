package _001_100._045_Jump_Game_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/23/2017.
 */
public class DynamicProgrammingSolutionTest {

  private DynameicProgrammingSolution solution;
  @Before
  public void setUp() throws Exception {
    solution = new DynameicProgrammingSolution();
  }

  @Test
  public void testWithOnlineCase() throws Exception {
    assertEquals(2, solution.jump(new int[]{2,3,1,1,4}));
  }

  @Test
  public void testWithSingleElement() throws Exception {
    assertEquals(0, solution.jump(new int[]{0}));
  }
}