package airbnb._415_Add_Strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/9/2019.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    assertEquals("0", solution.addStrings("0", "0"));
  }

  @Test
  void testOnlineCase2() throws Exception {
    assertEquals("10", solution.addStrings("1", "9"));
  }

  @Test
  void testOnlineCase3() throws Exception {
    assertEquals("77", solution.addStrings("33", "44"));
  }

  @Test
  void testOnlineCase4() throws Exception {
    assertEquals("114", solution.addStrings("76", "38"));
  }

}