package interviews.pinterest.thumbUp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  private Map<String, Long> urlToTimestamp = new HashMap<>();
  private Map<String, Set<String>> urlToUsers = new HashMap<>();


  public Solution(final String[][] entries) {
    for (String[] entry : entries) {
      final String url = entry[0], user = entry[1];
      final long timestamp = Long.parseLong(entry[2]);
      urlToTimestamp.putIfAbsent(url, timestamp);
      final Set<String> users = urlToUsers.getOrDefault(url, new HashSet<>());
      users.add(user);
      urlToUsers.put(url, users);
    }
  }

  public Map<String, Long> getEarliest() {
    return new HashMap<>(urlToTimestamp);
  }

  public String getSimilarUser(String user) {
    final Map<String, Long> userLikeCount = new HashMap<>();

    for (Map.Entry<String, Set<String>> e : urlToUsers.entrySet()) {
      final Set<String> users = e.getValue();
      if (users.contains(user)) {
        users.forEach(x -> {
          if (!user.equals(x)) {
            userLikeCount.put(x, userLikeCount.getOrDefault(x, 0L) + 1);
          }
        });
      }
    }
    long max = 0;
    String res = "";
    for (Map.Entry<String, Long> e : userLikeCount.entrySet()) {
      if (e.getValue() > max) {
        res = e.getKey();
        max = e.getValue();
      }
    }
    return res;
  }
}
