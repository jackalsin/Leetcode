package pinterest._811_Subdomain_Visit_Count;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String[] input =
        {"9001 discuss.leetcode.com"};
    Set<String> expected = Set.of(
        "9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com");

    assertEquals(expected, new HashSet<>(solution.subdomainVisits(input)));
  }

  @Test
  void testOnlineCase2() {
    final String[] input =
        {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
    final Set<String> expected = Set.of(
        "901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com", "951 com");

    assertEquals(expected, new HashSet<>(solution.subdomainVisits(input)));
  }

}