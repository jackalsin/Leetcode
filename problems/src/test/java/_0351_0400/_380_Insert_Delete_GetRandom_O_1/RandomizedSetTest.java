package _0351_0400._380_Insert_Delete_GetRandom_O_1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/9/2017.
 */
public class RandomizedSetTest {

  @Test
  public void testFailedCase1() throws Exception {
//  ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
//  [[],            [1],        [2],    [2],      [],       [1],      [2],        []]
    final RandomizedSet randomizedSet = new RandomizedSet();
    randomizedSet.insert(1);
    assertFalse(randomizedSet.remove(2));
    randomizedSet.insert(2);
    randomizedSet.getRandom();
    assertTrue(randomizedSet.remove(1));
    randomizedSet.insert(2);
    randomizedSet.getRandom();
  }

  /**
   * Didn't update the locations map after removing
   *
   * @throws Exception
   */
  @Test
  public void testFailedCase2() throws Exception {
//    ["RandomizedSet","insert","insert","remove","insert","insert","insert","remove","remove","insert","remove","insert","insert","insert","insert","insert","getRandom","insert","remove","insert","insert"]
//[[],                  [3],    [-2],     [2],      [1],      [-3],   [-2],     [-2],   [  3],    [-1],     [-3], [1],      [-2],     [-2],   [ -2],   [1],     [],         [-2],   [0],      [-3],[1]]

    final RandomizedSet randomizedSet = new RandomizedSet();
    assertTrue(randomizedSet.insert(3));
    assertTrue(randomizedSet.insert(-2));
    assertFalse(randomizedSet.remove(2));
    assertTrue(randomizedSet.insert(1));
    assertTrue(randomizedSet.insert(-3));
    assertFalse(randomizedSet.insert(-2));
    assertTrue(randomizedSet.remove(-2));
    assertTrue(randomizedSet.remove(3));

    assertTrue(randomizedSet.insert(-1));
    assertTrue(randomizedSet.remove(-3));

    assertFalse(randomizedSet.insert(1));
    assertTrue(randomizedSet.insert(-2));
    assertFalse(randomizedSet.insert(-2));
    assertFalse(randomizedSet.insert(-2));

    assertFalse(randomizedSet.insert(1));
    assertFalse(randomizedSet.insert(-2));

    assertFalse(randomizedSet.remove(0));
    assertTrue(randomizedSet.insert(-3));
    assertFalse(randomizedSet.insert(1));
  }
}
