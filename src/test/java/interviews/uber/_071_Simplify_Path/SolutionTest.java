package interviews.uber._071_Simplify_Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithRoot() {
    assertEquals("/", solution.simplifyPath("/"));
  }

  @Test
  void testWithRootSimple() {
    assertEquals("/", solution.simplifyPath("/c/c/../../"));
  }

  @Test
  void test1() {
    assertEquals("/c/e", solution.simplifyPath("/c/./c/../e"));
  }

  @Test
  void testMissed1() {
    assertEquals("/", solution.simplifyPath("/.."));
  }
}