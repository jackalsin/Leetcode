package interviews.oracle._715_Range_Module;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/13/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
//["addRange","queryRange","removeRange","removeRange","addRange","queryRange","addRange","queryRange", "removeRange"]
//[[5,8],       [3,4],        [5,6],        [3,6],      [1,3],      [2,3],      [4,8],      [2,3],        [4,9]]
//    [null,    false,        null,         null,         null,       true  ,   null,       true,           null]
    solution.addRange(5, 8);
    assertFalse(solution.queryRange(3, 4));
    solution.removeRange(5, 6);
    solution.removeRange(3, 6);
    solution.addRange(1, 3);
    assertTrue(solution.queryRange(2, 3));
    solution.addRange(4, 8);
    assertTrue(solution.queryRange(2, 3));
    solution.removeRange(4, 9);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
//    Input:
//["RangeModule","removeRange","addRange","queryRange","addRange","addRange","addRange","queryRange","queryRange",
//[[],            [8,9],        [6,10],     [4,7],      [3,4],      [1,5],      [3,6],      [2,4],      [7,8],
//[null,          null,         null,       false,        null,     null,       null,         true,       true,
// "queryRange","addRange","queryRange","removeRange","queryRange","queryRange","queryRange","removeRange",
// [1,4],          [4,5],     [7,8],      [8,9],          [1,7],      [4,5],      [1,8],        [2,5],
// true,            null,     true,       null,               true,     true,       true,       null,
// "queryRange","queryRange","removeRange","removeRange"]
// [2,7],         [4,6],         [1,3],       [2,9]]
// false,         true,         null,null]
//    Output:
//    Expected:
//[null,null,null,false,null,null,null,true,true,true,null,true,null,true,true,true,null,false,false,null,null]
    solution.removeRange(8, 9);
    solution.addRange(6, 10);
    assertFalse(solution.queryRange(4, 7));
    solution.addRange(3, 4);
    solution.addRange(1, 5);
    solution.addRange(3, 6);
    assertTrue(solution.queryRange(2, 4));
    assertTrue(solution.queryRange(7, 8));
    assertTrue(solution.queryRange(1, 4));
    solution.addRange(4, 5);
    assertTrue(solution.queryRange(7, 8));
    solution.removeRange(8, 9);
    assertTrue(solution.queryRange(1, 7));
    assertTrue(solution.queryRange(4, 5));
    assertTrue(solution.queryRange(1, 8));
    solution.removeRange(2, 5);
    assertFalse(solution.queryRange(2, 7));
    assertFalse(solution.queryRange(4, 6));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
//    Input:
//["addRange","removeRange","removeRange","addRange","removeRange","addRange","queryRange","queryRange","queryRange"]
//[[6,8],     [7,8],          [8,9],      [8,9],      [1,3],        [1,8],        [2,4] ,     [2,9],      [4,6]]
//    Output:
//[null,null,null,null,null,null,null,true,false,true]
//    Expected:
//[null,null,null,null,null,null,null,true,true,true]
    solution.addRange(6, 8);
    solution.removeRange(7, 8);
    solution.removeRange(8, 9);
    solution.addRange(8, 9);
    solution.removeRange(1, 3);
    solution.addRange(1, 8);
    assertTrue(solution.queryRange(2, 4));
    assertTrue(solution.queryRange(2, 9));
    assertTrue(solution.queryRange(4, 6));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    assertFalse(solution.queryRange(21, 34));
    assertFalse(solution.queryRange(27, 87));
    solution.addRange(44, 53);
    solution.addRange(69, 89);
    assertFalse(solution.queryRange(23, 26));
    assertTrue(solution.queryRange(80, 84));
    assertFalse(solution.queryRange(11, 12));
    solution.removeRange(86, 91);
    solution.addRange(87, 94);
    solution.removeRange(34, 52);
    solution.addRange(1, 59);
    solution.removeRange(62, 96);
    solution.removeRange(34, 83);
    assertFalse(solution.queryRange(11, 59));
    assertFalse(solution.queryRange(59, 79));
    assertTrue(solution.queryRange(1, 13));
    assertTrue(solution.queryRange(21, 23));
    solution.removeRange(9, 61);
    solution.addRange(17, 21);
    solution.removeRange(4, 8);
    assertFalse(solution.queryRange(19, 25));
    solution.addRange(71, 98);
    solution.addRange(23, 94);
    solution.removeRange(58, 95);
    assertFalse(solution.queryRange(12, 78));
    solution.removeRange(46, 47);
    solution.removeRange(50, 70);
    solution.removeRange(84, 91);
    solution.addRange(51, 63);
    solution.removeRange(26, 64);
    solution.addRange(38, 87);
    assertTrue(solution.queryRange(41, 84));
    assertTrue(solution.queryRange(19, 21));
    assertFalse(solution.queryRange(18, 56));
    assertFalse(solution.queryRange(23, 39));
    assertFalse(solution.queryRange(29, 95));
    solution.addRange(79, 100);
    solution.removeRange(76, 82);
    solution.addRange(37, 55);
    solution.addRange(30, 97);
    solution.addRange(1, 36);
    assertTrue(solution.queryRange(18, 96));
    solution.removeRange(45, 86);
    solution.addRange(74, 92);
    assertFalse(solution.queryRange(27, 78));
    solution.addRange(31, 35);
    assertTrue(solution.queryRange(87, 91));
    solution.removeRange(37, 84);
    solution.removeRange(26, 57);
    solution.addRange(65, 87);
    solution.addRange(76, 91);
    assertFalse(solution.queryRange(37, 77));
    assertFalse(solution.queryRange(18, 66));
    solution.addRange(22, 97);
    solution.addRange(2, 91);
    solution.removeRange(82, 98);
    solution.removeRange(41, 46);
    solution.removeRange(6, 78);
    assertFalse(solution.queryRange(44, 80));
    solution.removeRange(90, 94);
    solution.removeRange(37, 88);
    solution.addRange(75, 90);
    assertFalse(solution.queryRange(23, 37)); // failed here
    solution.removeRange(18, 80);
    solution.addRange(92, 93);
    solution.addRange(3, 80);
    assertTrue(solution.queryRange(68, 86));
    solution.removeRange(68, 92);
    assertFalse(solution.queryRange(52, 91));
    solution.addRange(43, 53);
    solution.addRange(36, 37);
    solution.addRange(60, 74);
    solution.addRange(4, 9);
    solution.addRange(44, 80);
    solution.removeRange(85, 93);
    solution.removeRange(56, 83);
    solution.addRange(9, 26);
    assertFalse(solution.queryRange(59, 64));
    assertFalse(solution.queryRange(16, 66));
    solution.removeRange(29, 36);
    solution.removeRange(51, 96);
    solution.removeRange(56, 80);
    solution.addRange(13, 87);
    assertTrue(solution.queryRange(42, 72));
    solution.removeRange(6, 56);
    assertFalse(solution.queryRange(24, 53));
    solution.addRange(43, 71);
    solution.removeRange(36, 83);
    solution.removeRange(15, 45);
    assertFalse(solution.queryRange(10, 48));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase7(Solution solution) {
    solution.addRange(9, 10);
    solution.addRange(10, 72);
    assertTrue(solution.queryRange(9, 72));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    // [null,null,null,null,false,false,null,null,null,null,null,false,null,null,null,null,false,false,null,null,
    // true,null,false,null,false,null,null,null,null,null,null,null,null,null,true,true,false,false,true,null,null,
    solution.addRange(55, 62);
    solution.addRange(1, 29);
    solution.removeRange(18, 49);
    assertFalse(solution.queryRange(6, 98));
    assertFalse(solution.queryRange(59, 71));
    solution.removeRange(40, 45);
    solution.removeRange(4, 58);
    solution.removeRange(57, 69);
    solution.removeRange(20, 30);
    solution.removeRange(1, 40);
    assertFalse(solution.queryRange(73, 93));
    solution.removeRange(32, 93);
    solution.addRange(38, 100);
    solution.removeRange(50, 64);
    solution.addRange(26, 72);
    assertFalse(solution.queryRange(8, 74));
    assertFalse(solution.queryRange(15, 53));
    solution.addRange(44, 85);
    solution.addRange(10, 71);
    assertTrue(solution.queryRange(54, 70));
    solution.removeRange(10, 45);
    assertFalse(solution.queryRange(30, 66));
    solution.addRange(47, 98);
    assertFalse(solution.queryRange(1, 7));
    solution.removeRange(44, 78);
    solution.removeRange(31, 49);
    solution.addRange(62, 63);
    solution.addRange(49, 88);
    solution.removeRange(47, 72);
    solution.removeRange(8, 50);
    solution.removeRange(49, 79);
    solution.addRange(31, 47);
    solution.addRange(54, 87);
    assertTrue(solution.queryRange(77, 78));
    assertTrue(solution.queryRange(59, 100));
    assertFalse(solution.queryRange(8, 9));
    assertFalse(solution.queryRange(50, 51));
    assertTrue(solution.queryRange(67, 93));
    // false,null,null,null,true,null,null,null,null,false,null,null,false,null,null,null,true,null,true,null,null,
    // null,null,false,null,false,false,null,false,null,null,false,null,null,false,null,null,null,null,null,null,
    solution.removeRange(25, 86);
    solution.removeRange(8, 92);
    solution.queryRange(31, 87);
    solution.addRange(90, 95);
    solution.addRange(28, 56);
    solution.addRange(10, 42);
    solution.queryRange(27, 34);
    solution.addRange(75, 81);
    solution.addRange(17, 63);
    solution.removeRange(78, 90);
    solution.addRange(9, 18);
    assertFalse(solution.queryRange(51, 74));
    solution.removeRange(20, 54);
    solution.addRange(35, 72);
    assertFalse(solution.queryRange(2, 29));
    solution.addRange(28, 41);
    solution.addRange(17, 95);
    solution.addRange(73, 75);
    assertTrue(solution.queryRange(34, 43));
    solution.addRange(57, 96);
    assertTrue(solution.queryRange(51, 72));
    solution.removeRange(21, 67);
    solution.removeRange(40, 73);
    solution.removeRange(14, 26);
    solution.removeRange(71, 86);
    assertFalse(solution.queryRange(34, 41));
    solution.removeRange(10, 25);
    assertFalse(solution.queryRange(27, 68));
    assertFalse(solution.queryRange(18, 32));
    solution.removeRange(30, 31);
    assertFalse(solution.queryRange(45, 61));
    solution.addRange(64, 66);
    solution.addRange(18, 93);
    assertFalse(solution.queryRange(13, 21));
    solution.removeRange(13, 46);
    solution.removeRange(56, 99);
    assertFalse(solution.queryRange(6, 93));
    solution.addRange(25, 36);
    solution.removeRange(27, 88);
    solution.removeRange(82, 83);
    solution.addRange(30, 71);
    solution.addRange(31, 73);
    solution.addRange(10, 41);
    // true,true,null,true,null,false,null,null,false]
    assertTrue(solution.queryRange(71, 72));
    assertTrue(solution.queryRange(9, 56));
    solution.addRange(22, 76);
    assertTrue(solution.queryRange(38, 74));
    solution.removeRange(2, 77);
    assertFalse(solution.queryRange(33, 61));
    solution.removeRange(74, 75);
    solution.addRange(11, 43);
    assertFalse(solution.queryRange(27, 75));
  }


  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}