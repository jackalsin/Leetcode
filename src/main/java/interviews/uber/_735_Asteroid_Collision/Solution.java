package interviews.uber._735_Asteroid_Collision;

import java.util.Stack;

public class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    final Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
      if (asteroid > 0) {
        stack.push(asteroid);
      } else {
        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
          stack.pop();
        }

        if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -asteroid) {
          stack.pop();
          continue;
        }
        if (stack.isEmpty() || stack.peek() < 0) {
          stack.push(asteroid);
        }
      }
    }
    final int[] rtn = new int[stack.size()];
    for (int i = 0; i < stack.size(); i++) {
      rtn[i] = stack.get(i);
    }
    return rtn;
  }
}
