package _801_850._825_Friends_Of_Appropriate_Ages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
//    solution = new NLogNSolution();
    solution = new ONSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[] ages = {16, 16};

    assertEquals(2, solution.numFriendRequests(ages));
  }

  @Test
  void testOnlineCase2() {
    final int[] ages = {16, 17, 18};

    assertEquals(2, solution.numFriendRequests(ages));
  }

  @Test
  void testOnlineCase3() {
    final int[] ages = {20, 30, 100, 110, 120};

    assertEquals(3, solution.numFriendRequests(ages));
  }

}