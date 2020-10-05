package _0351_0400._385_Mini_Parser;


import definition.nestedInteger._385_Mini_Parser.NestedInteger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class DequeRecursionSolution implements Solution {

  /**
   * Using for loop
   * 57 / 57 test cases passed.
   * Status: Accepted
   * Runtime: 20 ms
   *
   * @param s
   * @return
   */
  public NestedInteger deserialize(String s) {
    final char[] chars = s.toCharArray();
    final Deque<Character> charDeque = new ArrayDeque<>();
    for (final char chr : chars) {
      charDeque.addLast(chr);
    }

    return (Character.isDigit(charDeque.peekFirst()) || charDeque.peekFirst() == '-') ? deserializeInteger(charDeque) : deserializeList(charDeque);
  }

  private NestedInteger deserializeInteger(final Deque<Character> queue) {
    int num = 0, sign = 1;
    if (queue.peekFirst() == '-') {
      queue.removeFirst();
      sign = -1;
    }
    while (!queue.isEmpty() && Character.isDigit(queue.peekFirst())) {
      num = num * 10 + queue.removeFirst() - '0';
    }
    return new NestedInteger(sign * num);
  }

  private NestedInteger deserializeList(Deque<Character> queue) {
    final List<NestedInteger> res = new ArrayList<>();
    assert queue.removeFirst() == '[';
    int count = 1;

    while (count != 0) {
      final char chr = queue.removeFirst();
      if (Character.isDigit(chr) || chr == '-') {
        queue.addFirst(chr);
        res.add(deserializeInteger(queue));
      } else if (chr == ']') {
        count--;
      } else if (chr == '[') {
        queue.addFirst(chr);
        res.add(deserializeList(queue));
      }
    }
    final NestedInteger result = new NestedInteger();
//    Should use stream
//    res.forEach(result::add);
    for (final NestedInteger n : res) {
      result.add(n);
    }
    return result;
  }

}
