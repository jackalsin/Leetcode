package airbnb.guessNumber.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static airbnb.guessNumber.common.Settings.BREAK;
import static airbnb.guessNumber.common.Settings.PORT;

public final class Client {

  public String solve() {
    try (Socket socket = new Socket("localhost", PORT);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
    ) {
      // logic
      final Map<Integer, Integer> candidates = new HashMap<>();
      int totalCount = 0;
      // find all the candidates
      final Set<Integer> unselected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
      for (int i = 1; i <= 5; i++) {
        final String res = repeat(new StringBuilder(), (char) ('0' + i), 4).toString();
        out.println(res);
        final String resp = in.readLine();
        final String[] items = resp.split(" "); // hit and mispositioned
        final int hits = Integer.parseInt(items[0]);
        if (hits > 0) {
          totalCount += hits;
          candidates.put(i, hits);
          unselected.remove(i);
        }
      }
      // fill up to 4
      if (totalCount < 4) {
        candidates.put(6, 4 - totalCount);
      }
      for (int i = totalCount; i < 4; i++) {
        unselected.remove(6);
      }
      final StringBuilder result = new StringBuilder();
      final int invalid = unselected.iterator().next();
      for (final Map.Entry<Integer, Integer> e : candidates.entrySet()) {
        final StringBuilder sb = new StringBuilder(invalid);
        final int key = e.getKey();
        repeat(sb, (char) (key + '0'), 1);
        repeat(sb, (char) (invalid + '0'), 3);
        out.println(sb.toString());
        final String resp = in.readLine();
        if (resp.startsWith("1")) {
          result.append(key);
          break;
        }
      }
      removeCandidate(candidates, result.charAt(result.length() - 1));

      // find second one
      for (final Map.Entry<Integer, Integer> e : candidates.entrySet()) {
        final StringBuilder sb = new StringBuilder(result);
        final int key = e.getKey();
        repeat(sb, (char) (key + '0'), 1);
        repeat(sb, (char) (invalid + '0'), 2);
        out.println(sb.toString());
        final String resp = in.readLine();
        if (resp.startsWith("2")) {
          result.append(key);
          break;
        }
      }
      removeCandidate(candidates, result.charAt(result.length() - 1));

      // find third one
      for (final Map.Entry<Integer, Integer> e : candidates.entrySet()) {
        final StringBuilder sb = new StringBuilder(result);
        final int key = e.getKey();
        repeat(sb, (char) (key + '0'), 1);
        repeat(sb, (char) (invalid + '0'), 1);
        out.println(sb.toString());
        final String resp = in.readLine();
        if (resp.startsWith("3")) {
          result.append(key);
          break;
        }
      }
      removeCandidate(candidates, result.charAt(result.length() - 1));

      for (final Map.Entry<Integer, Integer> e : candidates.entrySet()) {
        result.append(e.getKey());
      }
      out.println(BREAK);
      return result.toString();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  private static void removeCandidate(final Map<Integer, Integer> candidates, final char chr) {
    final int i = chr - '0', count = candidates.get(i);
    if (count == 1) {
      candidates.remove(i);
    } else {
      candidates.put(i, count - 1);
    }
  }

  private static StringBuilder repeat(final StringBuilder sb, char chr, int repeat) {
    for (int i = 0; i < repeat; i++) {
      sb.append(chr);
    }
    return sb;
  }
}
