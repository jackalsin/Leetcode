package _0701_0750._715_Range_Module;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SegmentTreeSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SegmentTreeSolution();
  }

  @Test
  void testOnlineCase1() {
//    addRange(10, 20): null
//    removeRange(14, 16): null
//    queryRange(10, 14): true (Every number in [10, 14) is being tracked)
//    queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
//    queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
    solution.addRange(10, 20);
    solution.removeRange(14, 16);
    assertTrue(solution.queryRange(10, 14));
    assertFalse(solution.queryRange(13, 15));
    assertTrue(solution.queryRange(16, 17));

  }

  @Test
  void testOnlineCase2() {
//    ["RangeModule","addRange","addRange","addRange","queryRange","queryRange","queryRange","removeRange","queryRange"]
//    [[],[10,180],             [150,200],[250,500],[50,100],[180,300],[600,1000],[50,150],[50,100]]
    solution.addRange(10, 100);
    solution.addRange(150, 200);
    solution.addRange(250, 500);
    assertTrue(solution.queryRange(50, 100));
    assertFalse(solution.queryRange(180, 300));
    assertFalse(solution.queryRange(600, 1000));
    solution.removeRange(50, 150);
    assertFalse(solution.queryRange(50, 100));

  }

  @Test
  void testOnlineCase3() {
//    ["RangeModule","queryRange","queryRange","addRange","addRange","queryRange","queryRange","queryRange",
//[[],              [21,34],        [27,87],    [44,53],    [69,89],  [23,26],    [80,84],      [11,12],
//    [null,        false,          false,    null,       null,       false,      true,         false,
// "removeRange","addRange","removeRange","addRange","removeRange","removeRange","queryRange","queryRange",
// [86,91],       [87,94],  [34,52],        [1,59],   [62,96],      [34,83],      [11,59],    [59,79],
// null,            null,     null,         null,     null,         null,           false,    false,
// "queryRange","queryRange","removeRange","addRange","removeRange","queryRange","addRange","addRange","removeRange",
// [1,13],        [21,23],    [9,61],       [17,21],    [4,8],        [19,25],    [71,98],    [23,94],    [58,95],
// true,          true,       null,         null,       null,         false,      null,       null,         null,
// "queryRange","removeRange","removeRange","removeRange","addRange","removeRange","addRange","queryRange",
// [12,78],       [46,47],    [50,70],        [84,91],      [51,63],  [26,64],      [38,87],    [41,84],
// false,         null,       null,           null,         null,     null,           null,       true,
// "queryRange","queryRange","queryRange","queryRange","addRange","removeRange","addRange","addRange","addRange",
// [19,21],       [18,56],    [23,39],      [29,95],      [79,100],[76,82],     [37,55],    [30,97],  [1,36],
// true,            false,      false,        false,      null,     null,       null,         null,   null,
// "queryRange","removeRange","addRange","queryRange","addRange","queryRange","removeRange","removeRange","addRange",
// [18,96],       [45,86],      [74,92],    [27,78],    [31,35],    [87,91],    [37,84],[26,57],[65,87],[76,91],[37,77],[18,66],[22,97],[2,91],[82,98],[41,
// true,
// "addRange","queryRange","queryRange","addRange","addRange","removeRange","removeRange","removeRange","queryRange",
// "removeRange","removeRange","addRange","queryRange","removeRange","addRange","addRange","queryRange",
// "removeRange","queryRange","addRange","addRange","addRange","addRange","addRange","removeRange","removeRange",
// "addRange","queryRange","queryRange","removeRange","removeRange","removeRange","addRange","queryRange",
// "removeRange","queryRange","addRange","removeRange","removeRange","queryRange"]
// 46],[6,78],[44,80],[90,94],[37,88],[75,90],[23,37],[18,80],[92,93],[3,80],[68,86],[68,92],[52,91],[43,53],[36,37],
// [60,74],[4,9],[44,80],[85,93],[56,83],[9,26],[59,64],[16,66],[29,36],[51,96],[56,80],[13,87],[42,72],[6,56],[24,
// 53],[43,71],[36,83],[15,45],[10,48]]
//    assertFalse(solution.queryRange(21, 34));
//    assertFalse(solution.queryRange(27, 87));
//    solution.addRange(44, 53);
//    solution.addRange(69, 89);
//    assertFalse(solution.queryRange(23, 26));
//    assertTrue(solution.queryRange(80, 84));
//    assertFalse(solution.queryRange(11, 12));
//    solution.removeRange(86, 91);
//    solution.addRange(87, 94);
//    solution.removeRange(34, 52);
//    solution.addRange(1, 59);
//    solution.removeRange(62, 96);
//    solution.removeRange(34, 83);
//    assertFalse(solution.queryRange(11, 59));
//    assertFalse(solution.queryRange(59, 79));
//    assertTrue(solution.queryRange(1, 13));
//    assertTrue(solution.queryRange(21, 23));
//    solution.removeRange(9, 61);
//    solution.addRange(17, 21);
//    solution.removeRange(4, 8);
//    assertFalse(solution.queryRange(19, 25));
//

    solution.addRange(30, 97);
    assertTrue(solution.queryRange(30, 60));
    solution.addRange(1, 36);
    assertTrue(solution.queryRange(18, 96));

  }
}