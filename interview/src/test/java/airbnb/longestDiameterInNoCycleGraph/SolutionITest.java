package airbnb.longestDiameterInNoCycleGraph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final int[][] edges = {
        //    0, 1, 2, 3, 4, 5, 6
        /*0*/{0, 1, 0, 0, 0, 0, 0},
        /*1*/{1, 0, 1, 0, 0, 0, 0},
        /*2*/{0, 1, 0, 0, 1, 1, 0},
        /*3*/{0, 0, 0, 0, 0, 0, 0},
        /*4*/{0, 0, 1, 0, 0, 0, 1},
        /*5*/{0, 0, 1, 0, 0, 0, 0},
        /*6*/{0, 0, 0, 0, 1, 0, 0},
    };
    assertEquals(4, solution.getLongestDiameterOfGraph(edges));
  }
}