package _0501_0550._527_Word_Abbreviation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final List<String> input = List.of("like", "god", "internal", "me", "internet", "interval", "intension", "face",
        "intrusion");
    final List<String> expected = List.of("l2e", "god", "internal", "me", "i6t", "interval", "inte4n", "f2e", "intr4n");
    assertEquals(expected, solution.wordsAbbreviation(input));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final List<String> input = List.of("abcdefg", "abccefg", "abcckkg");
    final List<String> expected = List.of("abcd2g", "abccefg", "abcckkg");
    assertEquals(expected, solution.wordsAbbreviation(input));
  }


  //  unit test for help function
  @Test
  public void testGetAbbrGod() {
    assertEquals("god", Solution.getAbbr("god", 1, 1));
    assertEquals("l2e", Solution.getAbbr("like", 1, 2));
  }

  @Test
  public void testResolveConflict() {
    final String internal = "internal", interval = "interval";
    final String[] expected = {internal, interval};
    assertArrayEquals(expected, Solution.resolveConflict(internal, interval));
  }

  @Test
  public void testResolveConflict2() {
    final String internal = "internnnal", interval = "intervvval";
    final String[] expected = {"intern3l", "interv3l"};
    assertArrayEquals(expected, Solution.resolveConflict(internal, interval));
  }
}