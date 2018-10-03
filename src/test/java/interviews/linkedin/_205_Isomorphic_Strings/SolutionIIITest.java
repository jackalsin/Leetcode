package interviews.linkedin._205_Isomorphic_Strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionIII();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final String s = "egg";
    final String t = "add";
    assertTrue(solution.isIsomorphic(s, t));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String s = "foo";
    final String t = "bar";
    assertFalse(solution.isIsomorphic(s, t));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final String s = "paper";
    final String t = "title";
    assertTrue(solution.isIsomorphic(s, t));
  }
}