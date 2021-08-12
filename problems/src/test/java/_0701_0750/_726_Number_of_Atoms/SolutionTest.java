package _0701_0750._726_Number_of_Atoms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "H2O";
    final String expected = "H2O";
    assertEquals(expected, solution.countOfAtoms(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "Mg(OH)2";
    final String expected = "H2MgO2";
    assertEquals(expected, solution.countOfAtoms(input));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String input = "K4(ON(SO3)2)2";
    final String expected = "K4N2O14S4";
    assertEquals(expected, solution.countOfAtoms(input));
  }
}