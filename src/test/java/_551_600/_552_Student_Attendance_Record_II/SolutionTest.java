package _551_600._552_Student_Attendance_Record_II;

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
  public void testOnlineCase2() throws Exception {
    assertEquals(8, solution.checkRecord(2));
  }


  @Test
  public void testOnlineCase3() throws Exception {
    assertEquals(19, solution.checkRecord(3));
  }

  @Test
  public void testOnlineCase4() {
    assertEquals(43, solution.checkRecord(4));
  }

  @Test
  public void testOnlineCase5() {
    assertEquals(94, solution.checkRecord(5));
  }

  @Test
  public void testOnlineCase6() {
    assertEquals(200, solution.checkRecord(6));
  }

  @Test
  public void testOnlineCase100() {
    assertEquals(985598218, solution.checkRecord(100));
  }
}