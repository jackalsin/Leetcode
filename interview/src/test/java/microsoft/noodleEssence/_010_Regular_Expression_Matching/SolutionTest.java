package microsoft.noodleEssence._010_Regular_Expression_Matching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void isMatchWithEmptyString() throws Exception {
    assertTrue(solution.isMatch("", ""));
  }

  @Test
  void isMatchWithSameString() throws Exception {
    assertTrue(solution.isMatch("abc", "abc"));
  }

  @Test
  void isMatchWithAsteriskZeroLength() throws Exception {
    assertTrue(solution.isMatch("abc", "a*bc"));
  }

  @Test
  void isMatchWithAsteriskMoreThanOneLength() throws Exception {
    assertTrue(solution.isMatch("aaabc", "a*bc"));
  }

  @Test
  void isMatchWithDot() throws Exception {
    assertTrue(solution.isMatch("aabc", ".*bc"));
  }

  @Test
  void isMatchWithSingleDot() throws Exception {
    assertTrue(solution.isMatch("aebc", "a.bc"));
  }

  @Test
  void isMatchCaseOne() throws Exception {
    assertTrue(solution.isMatch("aaa", "ab*ac*a"));

  }

  @Test
  void isMatchCaseTwo() throws Exception {
    assertTrue(solution.isMatch("aaa", "ab*a*c*a"));
  }

}