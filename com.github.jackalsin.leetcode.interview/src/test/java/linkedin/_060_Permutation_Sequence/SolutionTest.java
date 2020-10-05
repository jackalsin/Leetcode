package linkedin._060_Permutation_Sequence;

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
  void testWith3And1() throws Exception {
    assertEquals("123", solution.getPermutation(3, 1));
  }

  @Test
  void testWith3And2() throws Exception {
    assertEquals("132", solution.getPermutation(3, 2));
  }

  @Test
  void testWith3And3() throws Exception {
    assertEquals("213", solution.getPermutation(3, 3));
  }

  @Test
  void testWith3And4() throws Exception {
    assertEquals("231", solution.getPermutation(3, 4));
  }
}