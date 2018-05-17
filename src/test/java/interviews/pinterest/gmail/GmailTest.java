package interviews.pinterest.gmail;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GmailTest {

  @Test
  void testOnlineCase1() {
    final Gmail gmail = new Gmail();

    gmail.addMessage("messaage 4", 4);
    gmail.addMessage("messaage 3", 3);
    gmail.addMessage("messaage 2", 2);
    gmail.addMessage("messaage 1", 1);
    final List<String> checkPoint1 = gmail.getAllConversations();
    final List<String> expected1 = List.of("messaage 1", "messaage 2", "messaage 3", "messaage 4");
    assertEquals(expected1, checkPoint1);

    gmail.addMessage("messaage 4 update", 4);
    final List<String> checkPoint2 = gmail.getAllConversations();
    final List<String> expected2 = List.of("messaage 4 update", "messaage 1", "messaage 2", "messaage 3");
    assertEquals(expected2, checkPoint2);

    gmail.addMessage("messaage 2 update", 2);

    final List<String> checkPoint3 = gmail.getAllConversations();
    final List<String> expected3 = List.of("messaage 2 update", "messaage 4 update", "messaage 1", "messaage 3");
    assertEquals(expected3, checkPoint3);
  }

}