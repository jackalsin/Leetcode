package _1151_1200._1172_Dinner_Plate_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements DinnerPlates {
  private final int capacity;

  /**
   * all the stacks
   */
  private final TreeMap<Integer, Deque<Integer>> stacks = new TreeMap<>();
  /**
   * available stacks.
   */
  private final TreeSet<Integer> availableStacks = new TreeSet<>();

  public SolutionI(int capacity) {
    this.capacity = capacity;
  }

  public void push(int val) {
    int index = 0;
    if (availableStacks.isEmpty()) {
      final var lastEntry = stacks.lastEntry();
      if (lastEntry != null) {
        index = lastEntry.getKey() + 1;
      }
      availableStacks.add(index);
    } else {
      index = availableStacks.first();
    }
    final Deque<Integer> stack = stacks.getOrDefault(index, new ArrayDeque<>());
    stack.push(val);
    if (stack.size() == capacity) {
      availableStacks.remove(index);
    }
    stacks.put(index, stack);
  }

  public int pop() {
    if (stacks.isEmpty()) return -1;
    return popAtStack(stacks.lastKey());
  }

  public int popAtStack(int index) {
    if (!stacks.containsKey(index)) return -1;
    final Deque<Integer> stack = stacks.get(index);
    final int result = stack.isEmpty() ? -1 : stack.pop();
    if (stack.isEmpty()) {
      stacks.remove(index);
    }
    availableStacks.add(index);
    return result;
  }
}
