package _701_750._735_Asteroid_Collision;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity O(N), space complexity O(N)
 *
 * @author jacka
 * @version 1.0 on 2/3/2018.
 */
public class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int asteroid : asteroids) {
      if (stack.isEmpty()) {
        stack.addLast(asteroid);
      } else {
        if (asteroid > 0) {
          stack.add(asteroid);
        } else if (asteroid < 0) {
          /*Pop all positive rocks smaller than the current one*/
          while ((!stack.isEmpty()) && stack.peekLast() > 0 &&
              Math.abs(stack.peekLast()) < Math.abs(asteroid)) {
            stack.removeLast();
          }
          if ((!stack.isEmpty()) && stack.peekLast() > 0 &&
              Math.abs(stack.peekLast()) == Math.abs(asteroid)) {
            stack.removeLast();
          } else if (stack.isEmpty() || stack.peekLast() < 0) {
            stack.addLast(asteroid);
          }
        }
      }
//      System.out.println(stack);
    }
    final int[] result = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
      result[i] = stack.removeLast();
    }
    return result;
  }
}
