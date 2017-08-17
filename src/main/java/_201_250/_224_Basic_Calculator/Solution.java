package _201_250._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/16/2017.
 */
public class Solution {
  public int calculate(String s) {
    int sum = 0;
    int num = 0;
    int sign = 1;
    Deque<Integer> stack = new ArrayDeque<>();
    for(char child : s.toCharArray()) {
      if (child == '+') {
        sum += sign * num;
        num = 0;
        sign = 1;
      } else if (child == '-') {
        sum += sign * num;
        num = 0;
        sign = -1;
      } else if (Character.isDigit(child)) {
        num = num * 10 + (child - '0');
      } else if (child == '(') {
        stack.push(sum);
        stack.push(sign);
        sum = 0;
        sign = 1;
      } else if (child == ')') {
        sign = stack.pop();
        sum = stack.pop();
        sum += sign * num;
        sign = 1;
        num = 0;
      }
    }
    if(num != 0) {
      sum += sign * num;
    }
    return sum;
  }

}
