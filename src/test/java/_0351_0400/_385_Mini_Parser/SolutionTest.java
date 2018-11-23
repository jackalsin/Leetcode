package _0351_0400._385_Mini_Parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.nestedInteger._385_Mini_Parser.NestedInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String s = "[123,[456,[789]]]";
    final NestedInteger i789 = new NestedInteger();
    i789.add(new NestedInteger(789));
    final NestedInteger i456 = new NestedInteger();
    i456.add(new NestedInteger(456));
    i456.add(i789);
    final NestedInteger i123 = new NestedInteger();
    i123.add(new NestedInteger(123));
    i123.add(i456);
    assertEquals(i123, solution.deserialize(s));

  }

  @Test
  void testOnlineCase2() {
    final String s = "456";
    assertEquals(new NestedInteger(456), solution.deserialize(s));
  }

  @Test
  void testFailedOnNegative() {
    final String s = "-456";
    assertEquals(new NestedInteger(-456), solution.deserialize(s));
  }
}