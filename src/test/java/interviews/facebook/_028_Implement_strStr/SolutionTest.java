package interviews.facebook._028_Implement_strStr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  // ----- test of substring -------------------
  @Test
  void testSubstring1() {
    final String haystack = "hello", needle = "ll";
    assertEquals(2, solution.strStr(haystack, needle));
  }

  @Test
  void testSubstring2() {
    final String haystack = "aaaaa", needle = "bba";
    assertEquals(-1, solution.strStr(haystack, needle));
  }

  // ----- getNext(final String pattern) --------
  @Test
  void testGetNext1() {
    final String p = "ABCDABD";
    final int[] expected = {-1, 0, 0, 0, 0, 1, 2};
    final int[] actual = Solution.getNext(p);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }

  @Test
  void testGetNext2() {
    final String p = "ABCDABCDABD";
    final int[] expected = {-1, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6};
    final int[] actual = Solution.getNext(p);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }

  @Test
  void testGetNext3() {
    final String p = "";
    final int[] expected = {};
    final int[] actual = Solution.getNext(p);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }


}