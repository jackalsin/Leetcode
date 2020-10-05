package airbnb.guessNumber;

import java.util.HashMap;
import java.util.Map;

public final class BruteForceSolution {
  private final Server server;

  public BruteForceSolution(final Server server) {
    this.server = server;
  }

  public String guess() {
    final Map<Integer, Integer> candidates = new HashMap<>();
    // find the digits
    for (int i = 1; i <= 6; i++) {
      final StringBuilder sb = new StringBuilder();
      for (int j = 0; j < 4; j++) {
        sb.append(i);
      }
      final String resp = server.get(sb.toString());
      final String[] items = resp.split(" ");
      final int count = Integer.parseInt(items[0]);
      for (int j = 0; j < count; j++) {
        candidates.put(i, candidates.getOrDefault(i, 0) + 1);
      }
    }
    // 用6补足
    final int diff = candidates.values().stream().mapToInt(Integer::intValue).sum();
    for (int i = 0; i + diff < 4; i++) {
      candidates.put(6, candidates.getOrDefault(6, 0) + 1);
    }
    final StringBuilder result = new StringBuilder();
    // 确定第一个, 3 次
    final int invalid = getInvalid(candidates);
    for (final Map.Entry<Integer, Integer> e : candidates.entrySet()) {
      final int cand = e.getKey();
      final StringBuilder sb = new StringBuilder().append(cand);
      repeat(sb, String.valueOf(invalid), 3);
      final String resp = server.get(sb.toString());
      final String[] items = resp.split(" ");
      if (items[0].equals("1")) {
        result.append(cand);
        break;
      }
    }
    // remove the candidate
    removeCandidates(candidates, result.charAt(result.length() - 1));

    // 确定第二个
    for (final Map.Entry<Integer, Integer> e : candidates.entrySet()) {
      final int cand = e.getKey();
      final StringBuilder sb = new StringBuilder(result).append(cand);
      repeat(sb, String.valueOf(invalid), 2);
      final String resp = server.get(sb.toString());
      final String[] items = resp.split(" ");
      if (items[0].equals("2")) {
        result.append(cand);
        break;
      }
    }
    // remove the candidate
    removeCandidates(candidates, result.charAt(result.length() - 1));
    // 确定第三个
    for (final Map.Entry<Integer, Integer> e : candidates.entrySet()) {
      final int cand = e.getKey();
      final StringBuilder sb = new StringBuilder(result).append(cand);
      repeat(sb, String.valueOf(invalid), 1);
      final String resp = server.get(sb.toString());
      final String[] items = resp.split(" ");
      if (items[0].equals("3")) {
        result.append(cand);
        break;
      }
    }
    removeCandidates(candidates, result.charAt(result.length() - 1));
    for (final Map.Entry<Integer, Integer> e : candidates.entrySet()) {
      result.append(e.getKey());
    }
    return result.toString();
  }

  private static void removeCandidates(final Map<Integer, Integer> candidates, final char chr) {
    final int key = chr - '0', count = candidates.get(key);
    if (count == 1) {
      candidates.remove(key);
    } else {
      candidates.put(key, candidates.getOrDefault(key, 0) - 1);
    }
  }

  private static int getInvalid(final Map<Integer, Integer> candidates) {
    for (int i = 1; i <= 6; i++) {
      if (!candidates.containsKey(i)) {
        return i;
      }
    }
    throw new IllegalStateException("Not found eligible: " + candidates);
  }

  private static void repeat(final StringBuilder sb, final String rep, final int times) {
    for (int i = 0; i < times; i++) {
      sb.append(rep);
    }
  }
}
