package _0701_0750._745_Prefix_and_Suffix_Search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/29/2018.
 */
public class WordFilterTwoDimensionSolutionTest {

  @Test
  public void testOnlineCase1() throws Exception {
    final String[] input = {"apple"};
    final WordFilterTwoDimensionSolution solution = new
        WordFilterTwoDimensionSolution(input);

    assertEquals(0, solution.f("a", "e"));
    assertEquals(0, solution.f("a", ""));
    assertEquals(-1, solution.f("b", ""));
    assertEquals(-1, solution.f("b", "e"));
    assertEquals(-1, solution.f("a", "l"));
    assertEquals(0, solution.f("ap", "le"));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String[] input = {"pop"};
    final WordFilterTwoDimensionSolution solution = new
        WordFilterTwoDimensionSolution(input);
//["WordFilter","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f",
// "f","f","f","f","f","f","f","f","f","f","f","f"]
//["",""],["","p"],["","gp"],["","pgp"],["p",""],["p","p"],["p","gp"],["p","pgp"],["pg",""],
// ["pg","p"],["pg","gp"],["pg","pgp"],["pgp",""],["pgp","p"],["pgp","gp"],["pgp","pgp"]]
    assertEquals(0, solution.f("", ""));
    assertEquals(0, solution.f("", "p"));
    assertEquals(0, solution.f("", "op"));
    assertEquals(0, solution.f("", "pop"));
    assertEquals(0, solution.f("p", ""));
    assertEquals(0, solution.f("p", "p"));
    assertEquals(0, solution.f("p", "op"));
    assertEquals(0, solution.f("p", "pop"));
    assertEquals(0, solution.f("po", ""));
    assertEquals(0, solution.f("po", "p"));
    assertEquals(0, solution.f("po", "op"));
    assertEquals(0, solution.f("po", "pop"));
    assertEquals(0, solution.f("pop", ""));
    assertEquals(0, solution.f("pop", "p"));
    assertEquals(0, solution.f("pop", "op"));
    assertEquals(0, solution.f("pop", "pop"));
    assertEquals(0, solution.f("", ""));
    assertEquals(0, solution.f("", "p"));
    assertEquals(-1, solution.f("", "gp"));
    assertEquals(-1, solution.f("", "pgp"));
    assertEquals(0, solution.f("p", ""));
    assertEquals(0, solution.f("p", "p"));
  }

}
