package _401_450._422_Valid_Word_Square;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final List<String> words = List.of(
        "abcd",
        "bnrt",
        "crmy",
        "dtye"

    );
    assertTrue(solution.validWordSquare(words));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final List<String> words = List.of(
        "abcd",
        "bnrt",
        "crm",
        "dt"

    );
    assertTrue(solution.validWordSquare(words));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final List<String> words = List.of(
        "ball",
        "area",
        "read",
        "lady"

    );
    assertFalse(solution.validWordSquare(words));
  }

  @Test
  public void testAdditionalRow() throws Exception {
    final List<String> words = List.of(
        "abcd",
        "bnrt",
        "crm",
        "dt",
        "a"
    );
    assertFalse(solution.validWordSquare(words));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final List<String> words = List.of(
        "ball",
        "asee",
        "let",
        "lep");
    assertFalse(solution.validWordSquare(words));
  }
}