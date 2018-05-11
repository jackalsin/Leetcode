package interviews.pinterest.similarUsers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  //  http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=423332&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

  public String findSimilarUser(final String[][] likes, final String user1) {
    final Map<String, Set<String>> websiteToUsers = new HashMap<>();
    final Set<String> user1Likes = new HashSet<>();
    for (final String[] entry : likes) {
      final String web = entry[0], user = entry[1];
      if (user.equals(user1)) {
        user1Likes.add(web);
      }
      final Set<String> users = websiteToUsers.getOrDefault(web, new HashSet<>());
      users.add(user);
      websiteToUsers.put(web, users);
    }

    // do count;
    final Map<String, Integer> userCount = new HashMap<>();

    for (final String website : user1Likes) {
      final Set<String> users = websiteToUsers.get(website);
      for (final String user : users) {
        if (user.equals(user1)) continue;
        userCount.put(user, userCount.getOrDefault(user, 0) + 1);
      }
    }

    // find max
    int max = 0;
    String user2 = null;
    for (final Map.Entry<String, Integer> entry : userCount.entrySet()) {
      final int curCount = entry.getValue();
      if (max < curCount) {
        max = curCount;
        user2 = entry.getKey();
      }
    }
    return user2;
  }
}

