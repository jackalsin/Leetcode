package doordash._721_Accounts_Merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SolutionI implements Solution {
  private static final int MAX_ACCOUNT = 1000, MAX_EMAIL_PER_ACCOUNT = 10;

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    final Map<Integer, String> emailIdToNames = new HashMap<>();
    final Map<String, Integer> emailToIds = new HashMap<>();
    int emailId = 0;
    final UnionFind uf = new UnionFind();
    for (final List<String> account : accounts) {
      final String name = account.get(0);
      for (int i = 1; i < account.size(); ++i) {
        final String email = account.get(i);
        if (!emailToIds.containsKey(email)) {
          emailToIds.put(email, emailId);
          emailIdToNames.put(emailId, name);
          ++emailId;
        }
        uf.union(emailToIds.get(account.get(1)), emailToIds.get(email));
      } // end of for int i
    }
    final Map<Integer, List<String>> idToEmails = new HashMap<>();
    for (final var e : emailToIds.entrySet()) {
      final String email = e.getKey();
      final int id = e.getValue(), rootId = uf.root(id);
      idToEmails.computeIfAbsent(rootId, k -> new ArrayList<>()).add(email);
    }

    final List<List<String>> result = new ArrayList<>();
    for (final Map.Entry<Integer, List<String>> e : idToEmails.entrySet()) {
      final int id = e.getKey();
      final List<String> emails = e.getValue();
      Collections.sort(emails);
      final String name = emailIdToNames.get(id);
      final List<String> cur = new ArrayList<>() {{
        add(name);
        addAll(emails);
      }};
      result.add(cur);
    }
    return result;
  }

  private static final class UnionFind {
    private static final int N = MAX_ACCOUNT * MAX_EMAIL_PER_ACCOUNT;
    private final int[] sizes = new int[N],
        roots = new int[N];

    {
      for (int i = 0; i < N; ++i) {
        sizes[i] = 1;
        roots[i] = i;
      }
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizeP;
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizeQ;
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }
  }
}
