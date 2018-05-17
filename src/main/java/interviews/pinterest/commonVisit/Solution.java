package interviews.pinterest.commonVisit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Solution {
  //  We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order and no URL was visited more than once per person.. 1point 3acres 璁哄潧
//
//  Write a function that takes two user’s browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.
//
//      user0 = [ "/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html" ]. From 1point 3acres bbs
//  user2 = [ "/nine.html", "/two.html", "/three.html", "/four.html", "/six.html", "/seven.html" ]
//  user1 = [ "/one.html", "/two.html", "/three.html", "/four.html", "/six.html" ]
//  user3 = [ "/three.html", "/eight.html" ]
//
//  Sample output:. from: 1point3acres.com/bbs
//
//      (user0, user2):
//      /four.html
//   /six.html
//   /seven.html
//
//       (user1, user2):
//      /two.html
//   /three.html
//   /four.html
//   /six.html
//
//       (user0, user3):
//  None
//      . from: 1point3acres.com/bbs
//      (user1, user3):
//      /three.html
  public List<String> getCommonVisit(final String[] user1, final String[] user2) {
    final Map<String, Integer> user1Visited = new HashMap<>();
    for (int i = 0; i < user1.length; i++) {
      user1Visited.put(user1[i], i);
    }

    final List<String> result = new ArrayList<>();
    for (int j = 0; j < user2.length; j++) {
      if (user1Visited.containsKey(user2[j])) {
        int i = user1Visited.get(user2[j]);
        final List<String> curPath = new ArrayList<>();
        for (; i < user1.length && j < user2.length; i++, j++) {
          if (user1[i].equals(user2[j])) {
            curPath.add(user1[i]);
          } else {
            j--;
            break;
          }
        }
        if (curPath.size() > result.size()) {
          result.clear();
          result.addAll(curPath);
        }
      }
    }
    return result;
  }

}
