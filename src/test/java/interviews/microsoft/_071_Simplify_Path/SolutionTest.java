package interviews.microsoft._071_Simplify_Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithRoot() throws Exception {
    assertEquals("/", solution.simplifyPath("/"));
  }

  @Test
  void testWithRootSimple() throws Exception {
    assertEquals("/", solution.simplifyPath("/c/c/../../"));
  }

  @Test
  void test1() throws Exception {
    assertEquals("/c/e", solution.simplifyPath("/c/./c/../e"));
  }

  @Test
  void testMissed1() throws Exception {
    assertEquals("/", solution.simplifyPath("/.."));
  }
}