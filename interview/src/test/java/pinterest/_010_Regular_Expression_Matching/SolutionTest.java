package pinterest._010_Regular_Expression_Matching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void isMatchWithEmptyString() {
    assertTrue(solution.isMatch("", ""));
  }

  @Test
  void isMatchWithSameString() {
    assertTrue(solution.isMatch("abc", "abc"));
  }

  @Test
  void isMatchWithAsteriskZeroLength() {
    assertTrue(solution.isMatch("abc", "a*bc"));
  }

  @Test
  void isMatchWithAsteriskMoreThanOneLength() {
    assertTrue(solution.isMatch("aaabc", "a*bc"));
  }

  @Test
  void isMatchWithDot() {
    assertTrue(solution.isMatch("aabc", ".*bc"));
  }

  @Test
  void isMatchWithSingleDot() {
    assertTrue(solution.isMatch("aebc", "a.bc"));
  }

  @Test
  void isMatchCaseOne() {
    assertTrue(solution.isMatch("aaa", "ab*ac*a"));

  }

  @Test
  void isMatchCaseTwo() {
    assertTrue(solution.isMatch("aaa", "ab*a*c*a"));
  }
}