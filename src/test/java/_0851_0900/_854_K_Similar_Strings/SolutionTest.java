package _0851_0900._854_K_Similar_Strings;

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
    final String A = "ab", B = "ba";
    assertEquals(1, solution.kSimilarity(A, B));
  }

  @Test
  void testOnlineCase2() {
    final String A = "abc", B = "bca";
    assertEquals(2, solution.kSimilarity(A, B));

  }

  @Test
  void testOnlineCase3() {
    final String A = "abac", B = "baca";
    assertEquals(2, solution.kSimilarity(A, B));
  }

  @Test
  void testOnlineCase4() {
    final String A = "aabc", B = "abca";
    assertEquals(2, solution.kSimilarity(A, B));
  }

  @Test
  void testTLE() {
    final String A = "cdebcdeadedaaaebfbcf", B = "baaddacfedebefdabecc";
    assertEquals(12, solution.kSimilarity(A, B));
  }

}