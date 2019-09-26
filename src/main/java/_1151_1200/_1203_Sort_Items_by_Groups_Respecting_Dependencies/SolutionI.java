package _1151_1200._1203_Sort_Items_by_Groups_Respecting_Dependencies;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/23/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
    final Map<Integer, Set<Integer>> groupIdToItems = new HashMap<>();
    final Map<Integer, Set<Integer>> itemParentToChildren = new HashMap<>(),
        groupParentToChildren = new HashMap<>();
    final Map<Integer, Integer> itemIndegree = new HashMap<>(),
        groupIndegree = new HashMap<>();
    // recode group id
    int minGroup = m;
    for (int i = 0; i < n; ++i) {
      if (group[i] == -1) {
        group[i] = minGroup++;
      }
      groupIdToItems.computeIfAbsent(group[i], k -> new HashSet<>()).add(i);
    }
//    System.out.println("New Group:" + Arrays.toString(group));
    for (int to = 0; to < group.length; ++to) {
      final int toGroupId = group[to];
      for (int from : beforeItems.get(to)) {
        final int fromGroupId = group[from];
        if (toGroupId == fromGroupId) {
          itemIndegree.put(to, itemIndegree.getOrDefault(to, 0) + 1);
          itemParentToChildren.computeIfAbsent(from, k -> new HashSet<>()).add(to);
        } else {
          final boolean notHas =
              groupParentToChildren.computeIfAbsent(fromGroupId, k -> new HashSet<>()).add(toGroupId);
          if (notHas) {
            groupIndegree.put(toGroupId, groupIndegree.getOrDefault(toGroupId, 0) + 1);
          }
        }
      }
    }

//    System.out.println(itemParentToChildren);
//    System.out.println(groupParentToChildren);

    // step2: check if group dependency are clear
    final List<Integer> groupResult = new ArrayList<>();
    final Queue<Integer> groupQ = new ArrayDeque<>();
    for (int i = 0; i < minGroup; ++i) {
      if (!groupIndegree.containsKey(i)) {
        groupResult.add(i);
        groupQ.add(i);
      }
    }
//    System.out.println("groupQ: " + groupQ);
    while (!groupQ.isEmpty()) {
      final int groupId = groupQ.remove();
      for (int toGroupId : groupParentToChildren.getOrDefault(groupId, new HashSet<>())) {
        groupIndegree.put(toGroupId, groupIndegree.get(toGroupId) - 1);
        if (groupIndegree.get(toGroupId) == 0) {
          groupQ.add(toGroupId);
          groupResult.add(toGroupId);
          groupIndegree.remove(toGroupId);
        }
      }
    }
    if (groupResult.size() != minGroup) {
//      System.out.println("Group Result: " + groupResult);
      return new int[]{};
    }

    // step 3: check the group
    final List<Integer> result = new ArrayList<>();
    for (int groupId : groupResult) {
      final Set<Integer> itemsInGroup = groupIdToItems.getOrDefault(groupId, new HashSet<>());
      final Queue<Integer> itemQ = new ArrayDeque<>();
      int cur = 0;
      for (int itemId : itemsInGroup) {
        if (itemIndegree.containsKey(itemId)) continue;
        itemQ.add(itemId);
        cur++;
        result.add(itemId);
      }
      while (!itemQ.isEmpty()) {
        final int itemId = itemQ.remove();
        final Set<Integer> children = itemParentToChildren.getOrDefault(itemId, new HashSet<>());
        for (int c : children) {
          itemIndegree.put(c, itemIndegree.getOrDefault(c, 0) - 1);
          if (itemIndegree.getOrDefault(c, 0) == 0) {
            itemQ.add(c);
            cur++;
            result.add(c);
          }
        }
      } // end of while

      if (cur != itemsInGroup.size()) {
//        System.out.println("result: " + result + "\ncur: "+ cur
//            + "\n" + itemsInGroup);
        return new int[]{};
      }
    }
    return toArray(result);
  }

  private static int[] toArray(final List<Integer> input) {
    final int[] res = new int[input.size()];
    for (int i = 0; i < input.size(); ++i) {
      res[i] = input.get(i);
    }
    return res;
  }
}
