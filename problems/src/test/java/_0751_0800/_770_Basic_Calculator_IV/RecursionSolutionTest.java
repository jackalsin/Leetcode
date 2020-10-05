package _0751_0800._770_Basic_Calculator_IV;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursionSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new RecursionSolution();
  }

  @Test
  void testOnlineCase1() {
    final String expression = "e + 8 - a + 5";
    final String[] evalvars = {"e"};
    final int[] evalints = {1};
    final List<String> expected = List.of("-1*a", "14");
    assertEquals(expected, solution.basicCalculatorIV(expression, evalvars, evalints));
  }

  @Test
  void testOnlineCase2() {
    final String expression = "e - 8 + temperature - pressure";
    final String[] evalvars = {"e", "temperature"};
    final int[] evalints = {1, 12};
    final List<String> expected = List.of("-1*pressure", "5");
    assertEquals(expected, solution.basicCalculatorIV(expression, evalvars, evalints));
  }

  @Test
  void testOnlineCase3() {
    final String expression = "(e + 8) * (e - 8)";
    final String[] evalvars = {};
    final int[] evalints = {};
    final List<String> expected = List.of("1*e*e", "-64");
    assertEquals(expected, solution.basicCalculatorIV(expression, evalvars, evalints));

  }

  @Test
  void testOnlineCase4() {
    final String expression = "7 - 7";
    final String[] evalvars = {};
    final int[] evalints = {};
    final List<String> expected = List.of();
    assertEquals(expected, solution.basicCalculatorIV(expression, evalvars, evalints));
  }

  @Test
  void testOnlineCase5() {
    final String expression = "a * b * c + b * a * c * 4";
    final String[] evalvars = {};
    final int[] evalints = {};
    final List<String> expected = List.of("5*a*b*c");
    assertEquals(expected, solution.basicCalculatorIV(expression, evalvars, evalints));
  }

  @Test
  void testOnlineCase6() {
    final String expression = "((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))";
    final String[] evalvars = {};
    final int[] evalints = {};
    final List<String> expected = List.of("-1*a*a*b*b", "2*a*a*b*c", "-1*a*a*c*c", "1*a*b*b*b", "-1*a*b*b*c", "-1*a*b*c*c", "1*a*c*c*c", "-1*b*b*b*c", "2*b*b*c*c", "-1*b*c*c*c", "2*a*a*b", "-2*a*a*c", "-2*a*b*b", "2*a*c*c", "1*b*b*b", "-1*b*b*c", "1*b*c*c", "-1*c*c*c", "-1*a*a", "1*a*b", "1*a*c", "-1*b*c");
    assertEquals(expected, solution.basicCalculatorIV(expression, evalvars, evalints));
  }
}