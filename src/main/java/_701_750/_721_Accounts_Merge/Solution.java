package _701_750._721_Accounts_Merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution { // TODO: Redo

  private static final int MAX_ACCOUNT = 1000, MAX_EMAIL_PER_ACCOUNT = 10;

  /**
   * The length of accounts will be in the range [1, 1000]. // accounts number
   * The length of accounts[i] will be in the range [1, 10].  // emails
   * The length of accounts[i][j] will be in the range [1, 30]. // email length
   *
   * @param accounts
   * @return
   */
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    final Map<String, Integer> emailToId = new HashMap<>();
    final Map<Integer, String> idToName = new HashMap<>();
    final UnionFind uf = new UnionFind();
    int id = 0;
    for (final List<String> account : accounts) {
      final String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        final String email = account.get(i);
        if (!emailToId.containsKey(email)) {
          emailToId.put(email, ++id);
          idToName.put(id, name);
        }
        uf.union(emailToId.get(account.get(1)), emailToId.get(email));
      }
    }

//    System.out.println(emailToId);
//    System.out.println(Arrays.toString(uf.root));
    final Map<Integer, List<String>> idToEmails = new HashMap<>();
    for (final Map.Entry<String, Integer> entry : emailToId.entrySet()) {
      final String email = entry.getKey();
      final int emailId = entry.getValue(), parentId = uf.root(emailId);
      idToEmails.putIfAbsent(parentId, new ArrayList<>());
      idToEmails.get(parentId).add(email);
    }

    for (final Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()) {
      final List<String> component = entry.getValue();
      Collections.sort(component);
      final int curId = emailToId.get(component.get(0));
      component.add(0, idToName.get(curId));
    }
    return new ArrayList<>(idToEmails.values());
  }

  private static final class UnionFind {
    private static final int SIZE = MAX_ACCOUNT * MAX_EMAIL_PER_ACCOUNT + 1;
    private final int[] root = new int[SIZE];

    public UnionFind() {
      for (int i = 1; i < SIZE; i++) {
        root[i] = i;
      }
    }

    int root(int p) {
      while (p != root[p]) {
        root[p] = root[root[p]]; // use path compression
        p = root[p];
      }
      return p;
    }

    void union(int p, int q) {
      final int rootP = root(p), rootQ = root(q);
      if (rootP <= rootQ) {
        root[rootQ] = rootP;
      } else {
        root[rootP] = rootQ;
      }
    }
  }
}
