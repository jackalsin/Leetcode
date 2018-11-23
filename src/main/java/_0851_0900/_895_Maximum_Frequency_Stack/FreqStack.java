package _0851_0900._895_Maximum_Frequency_Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public final class FreqStack {

  private final Map<Integer, Integer> keyToFreq = new HashMap<>();
  private final Map<Integer, Deque<Integer>> freqToStack = new HashMap<>();
  private int maxFreq = 0;

  public void push(int x) {
    final int newFreq = keyToFreq.getOrDefault(x, 0) + 1;
    keyToFreq.put(x, newFreq);
    maxFreq = Math.max(maxFreq, newFreq);
    freqToStack.putIfAbsent(newFreq, new ArrayDeque<>());
    freqToStack.get(newFreq).push(x);
  }

  public int pop() {
    final int res = freqToStack.get(maxFreq).pop();
    keyToFreq.put(res, keyToFreq.get(res) - 1);
    if (freqToStack.get(maxFreq).size() == 0) {
      maxFreq--;
    }
    return res;
  }
}
