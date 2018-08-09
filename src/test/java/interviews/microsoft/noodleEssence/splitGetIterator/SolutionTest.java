package interviews.microsoft.noodleEssence.splitGetIterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String str = "abc:xy,mf";

    assertEquals("abc", solution.get(":,", str));
    assertEquals("xy", solution.get(":,", null));
    assertEquals("mf", solution.get(":,", null));
  }


}