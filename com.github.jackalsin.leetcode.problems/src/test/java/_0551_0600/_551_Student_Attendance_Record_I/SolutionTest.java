package _0551_0600._551_Student_Attendance_Record_I;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "PPALLP";
    assertTrue(solution.checkRecord(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "PPALLL";
    assertFalse(solution.checkRecord(input));
  }
}
