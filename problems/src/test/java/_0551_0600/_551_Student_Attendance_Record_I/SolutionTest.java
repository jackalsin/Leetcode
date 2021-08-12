package _0551_0600._551_Student_Attendance_Record_I;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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
