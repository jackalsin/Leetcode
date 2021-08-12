package google._481_Magical_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(3, solution.magicalString(6));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals(5, solution.magicalString(12));
  }

  @Test
  public void testFailedOnCountOfOne() throws Exception {
    assertEquals(2, solution.magicalString(4));
  }
}
