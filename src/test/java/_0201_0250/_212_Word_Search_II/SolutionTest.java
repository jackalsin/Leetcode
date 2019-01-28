package _0201_0250._212_Word_Search_II;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/8/2017.
 */
class SolutionTest {
  private Solution solution;

  private static final char[][] BOARD = new char[][] {
      {'o','a','a','n'},
      {'e','t','a','e'},
      {'i','h','k','r'},
      {'i','f','l','v'}
  };

  private static final char[][] BOARD2 = new char[][] {
      {'a', 'b'},
      {'a', 'a'}
  };

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmptyBoard() throws Exception {
    assertEquals(new ArrayList<>(), solution.findWords(new char[][]{}, new String[]{"a"}));
  }

  @Test
  void testEmptyWords() throws Exception {
    assertEquals(new ArrayList<>(), solution.findWords(BOARD, new String[]{}));
  }

  @Test
  void testOnlineCase() throws Exception {
    final String[] words = new String[] { "oath", "pea", "eat", "rain" };
    List<String> expected = Arrays.asList("eat", "oath");
    List<String> actual = solution.findWords(BOARD, words);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void testTLE() throws Exception {
    String[] boardString = new String[] {"aaaa","aaaa","aaaa","aaaa","bcde","fghi","jklm","nopq",
        "rstu", "vwxy", "zzzz"};
    String[] words = new String[] { "aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac",
        "aaaaaaaaaaaaaaad", "aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaf","aaaaaaaaaaaaaaag",
        "aaaaaaaaaaaaaaah", "aaaaaaaaaaaaaaai","aaaaaaaaaaaaaaaj","aaaaaaaaaaaaaaak",
        "aaaaaaaaaaaaaaal", "aaaaaaaaaaaaaaam","aaaaaaaaaaaaaaan","aaaaaaaaaaaaaaao",
        "aaaaaaaaaaaaaaap", "aaaaaaaaaaaaaaaq","aaaaaaaaaaaaaaar","aaaaaaaaaaaaaaas",
        "aaaaaaaaaaaaaaat", "aaaaaaaaaaaaaaau","aaaaaaaaaaaaaaav","aaaaaaaaaaaaaaaw",
        "aaaaaaaaaaaaaaax", "aaaaaaaaaaaaaaay","aaaaaaaaaaaaaaaz","aaaaaaaaaaaaaaaa",
        "aaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae",
        "aaaaaaaaaaaaaaaf", "aaaaaaaaaaaaaaag","aaaaaaaaaaaaaaah","aaaaaaaaaaaaaaai",
        "aaaaaaaaaaaaaaaj", "aaaaaaaaaaaaaaak","aaaaaaaaaaaaaaal","aaaaaaaaaaaaaaam",
        "aaaaaaaaaaaaaaan", "aaaaaaaaaaaaaaao","aaaaaaaaaaaaaaap","aaaaaaaaaaaaaaaq",
        "aaaaaaaaaaaaaaar", "aaaaaaaaaaaaaaas","aaaaaaaaaaaaaaat","aaaaaaaaaaaaaaau",
        "aaaaaaaaaaaaaaav", "aaaaaaaaaaaaaaaw","aaaaaaaaaaaaaaax","aaaaaaaaaaaaaaay",
        "aaaaaaaaaaaaaaaz", "aaaaaaaaaaaaaaba","aaaaaaaaaaaaaabb","aaaaaaaaaaaaaabc",
        "aaaaaaaaaaaaaabd", "aaaaaaaaaaaaaabe","aaaaaaaaaaaaaabf","aaaaaaaaaaaaaabg",
        "aaaaaaaaaaaaaabh", "aaaaaaaaaaaaaabi","aaaaaaaaaaaaaabj","aaaaaaaaaaaaaabk",
        "aaaaaaaaaaaaaabl", "aaaaaaaaaaaaaabm","aaaaaaaaaaaaaabn","aaaaaaaaaaaaaabo",
        "aaaaaaaaaaaaaabp", "aaaaaaaaaaaaaabq","aaaaaaaaaaaaaabr","aaaaaaaaaaaaaabs",
        "aaaaaaaaaaaaaabt", "aaaaaaaaaaaaaabu","aaaaaaaaaaaaaabv","aaaaaaaaaaaaaabw",
        "aaaaaaaaaaaaaabx", "aaaaaaaaaaaaaaby","aaaaaaaaaaaaaabz","aaaaaaaaaaaaaaca",
        "aaaaaaaaaaaaaacb", "aaaaaaaaaaaaaacc","aaaaaaaaaaaaaacd","aaaaaaaaaaaaaace",
        "aaaaaaaaaaaaaacf", "aaaaaaaaaaaaaacg","aaaaaaaaaaaaaach","aaaaaaaaaaaaaaci",
        "aaaaaaaaaaaaaacj", "aaaaaaaaaaaaaack","aaaaaaaaaaaaaacl","aaaaaaaaaaaaaacm",
        "aaaaaaaaaaaaaacn", "aaaaaaaaaaaaaaco","aaaaaaaaaaaaaacp","aaaaaaaaaaaaaacq",
        "aaaaaaaaaaaaaacr", "aaaaaaaaaaaaaacs","aaaaaaaaaaaaaact","aaaaaaaaaaaaaacu",
        "aaaaaaaaaaaaaacv", "aaaaaaaaaaaaaacw","aaaaaaaaaaaaaacx","aaaaaaaaaaaaaacy",
        "aaaaaaaaaaaaaacz", "aaaaaaaaaaaaaada","aaaaaaaaaaaaaadb","aaaaaaaaaaaaaadc",
        "aaaaaaaaaaaaaadd", "aaaaaaaaaaaaaade","aaaaaaaaaaaaaadf","aaaaaaaaaaaaaadg",
        "aaaaaaaaaaaaaadh", "aaaaaaaaaaaaaadi","aaaaaaaaaaaaaadj","aaaaaaaaaaaaaadk",
        "aaaaaaaaaaaaaadl", "aaaaaaaaaaaaaadm","aaaaaaaaaaaaaadn","aaaaaaaaaaaaaado",
        "aaaaaaaaaaaaaadp", "aaaaaaaaaaaaaadq","aaaaaaaaaaaaaadr","aaaaaaaaaaaaaads",
        "aaaaaaaaaaaaaadt", "aaaaaaaaaaaaaadu","aaaaaaaaaaaaaadv","aaaaaaaaaaaaaadw",
        "aaaaaaaaaaaaaadx", "aaaaaaaaaaaaaady","aaaaaaaaaaaaaadz","aaaaaaaaaaaaaaea",
        "aaaaaaaaaaaaaaeb", "aaaaaaaaaaaaaaec","aaaaaaaaaaaaaaed","aaaaaaaaaaaaaaee",
        "aaaaaaaaaaaaaaef", "aaaaaaaaaaaaaaeg","aaaaaaaaaaaaaaeh","aaaaaaaaaaaaaaei",
        "aaaaaaaaaaaaaaej","aaaaaaaaaaaaaaek","aaaaaaaaaaaaaael","aaaaaaaaaaaaaaem",
        "aaaaaaaaaaaaaaen","aaaaaaaaaaaaaaeo","aaaaaaaaaaaaaaep","aaaaaaaaaaaaaaeq",
        "aaaaaaaaaaaaaaer","aaaaaaaaaaaaaaes","aaaaaaaaaaaaaaet","aaaaaaaaaaaaaaeu",
        "aaaaaaaaaaaaaaev","aaaaaaaaaaaaaaew","aaaaaaaaaaaaaaex","aaaaaaaaaaaaaaey",
        "aaaaaaaaaaaaaaez","aaaaaaaaaaaaaafa","aaaaaaaaaaaaaafb","aaaaaaaaaaaaaafc",
        "aaaaaaaaaaaaaafd","aaaaaaaaaaaaaafe","aaaaaaaaaaaaaaff","aaaaaaaaaaaaaafg",
        "aaaaaaaaaaaaaafh","aaaaaaaaaaaaaafi","aaaaaaaaaaaaaafj","aaaaaaaaaaaaaafk",
        "aaaaaaaaaaaaaafl","aaaaaaaaaaaaaafm","aaaaaaaaaaaaaafn","aaaaaaaaaaaaaafo",
        "aaaaaaaaaaaaaafp","aaaaaaaaaaaaaafq","aaaaaaaaaaaaaafr","aaaaaaaaaaaaaafs",
        "aaaaaaaaaaaaaaft","aaaaaaaaaaaaaafu","aaaaaaaaaaaaaafv","aaaaaaaaaaaaaafw",
        "aaaaaaaaaaaaaafx","aaaaaaaaaaaaaafy","aaaaaaaaaaaaaafz","aaaaaaaaaaaaaaga",
        "aaaaaaaaaaaaaagb","aaaaaaaaaaaaaagc","aaaaaaaaaaaaaagd","aaaaaaaaaaaaaage",
        "aaaaaaaaaaaaaagf","aaaaaaaaaaaaaagg","aaaaaaaaaaaaaagh","aaaaaaaaaaaaaagi",
        "aaaaaaaaaaaaaagj","aaaaaaaaaaaaaagk","aaaaaaaaaaaaaagl","aaaaaaaaaaaaaagm",
        "aaaaaaaaaaaaaagn","aaaaaaaaaaaaaago","aaaaaaaaaaaaaagp","aaaaaaaaaaaaaagq",
        "aaaaaaaaaaaaaagr","aaaaaaaaaaaaaags","aaaaaaaaaaaaaagt","aaaaaaaaaaaaaagu",
        "aaaaaaaaaaaaaagv","aaaaaaaaaaaaaagw","aaaaaaaaaaaaaagx","aaaaaaaaaaaaaagy",
        "aaaaaaaaaaaaaagz","aaaaaaaaaaaaaaha","aaaaaaaaaaaaaahb","aaaaaaaaaaaaaahc",
        "aaaaaaaaaaaaaahd","aaaaaaaaaaaaaahe","aaaaaaaaaaaaaahf","aaaaaaaaaaaaaahg",
        "aaaaaaaaaaaaaahh","aaaaaaaaaaaaaahi","aaaaaaaaaaaaaahj","aaaaaaaaaaaaaahk",
        "aaaaaaaaaaaaaahl","aaaaaaaaaaaaaahm","aaaaaaaaaaaaaahn","aaaaaaaaaaaaaaho",
        "aaaaaaaaaaaaaahp","aaaaaaaaaaaaaahq","aaaaaaaaaaaaaahr","aaaaaaaaaaaaaahs",
        "aaaaaaaaaaaaaaht","aaaaaaaaaaaaaahu","aaaaaaaaaaaaaahv","aaaaaaaaaaaaaahw",
        "aaaaaaaaaaaaaahx","aaaaaaaaaaaaaahy","aaaaaaaaaaaaaahz","aaaaaaaaaaaaaaia",
        "aaaaaaaaaaaaaaib","aaaaaaaaaaaaaaic","aaaaaaaaaaaaaaid","aaaaaaaaaaaaaaie",
        "aaaaaaaaaaaaaaif","aaaaaaaaaaaaaaig","aaaaaaaaaaaaaaih","aaaaaaaaaaaaaaii",
        "aaaaaaaaaaaaaaij","aaaaaaaaaaaaaaik","aaaaaaaaaaaaaail","aaaaaaaaaaaaaaim",
        "aaaaaaaaaaaaaain","aaaaaaaaaaaaaaio","aaaaaaaaaaaaaaip","aaaaaaaaaaaaaaiq",
        "aaaaaaaaaaaaaair","aaaaaaaaaaaaaais","aaaaaaaaaaaaaait","aaaaaaaaaaaaaaiu",
        "aaaaaaaaaaaaaaiv","aaaaaaaaaaaaaaiw","aaaaaaaaaaaaaaix","aaaaaaaaaaaaaaiy",
        "aaaaaaaaaaaaaaiz","aaaaaaaaaaaaaaja","aaaaaaaaaaaaaajb","aaaaaaaaaaaaaajc",
        "aaaaaaaaaaaaaajd","aaaaaaaaaaaaaaje","aaaaaaaaaaaaaajf","aaaaaaaaaaaaaajg",
        "aaaaaaaaaaaaaajh","aaaaaaaaaaaaaaji","aaaaaaaaaaaaaajj","aaaaaaaaaaaaaajk",
        "aaaaaaaaaaaaaajl","aaaaaaaaaaaaaajm","aaaaaaaaaaaaaajn","aaaaaaaaaaaaaajo",
        "aaaaaaaaaaaaaajp","aaaaaaaaaaaaaajq","aaaaaaaaaaaaaajr","aaaaaaaaaaaaaajs",
        "aaaaaaaaaaaaaajt","aaaaaaaaaaaaaaju","aaaaaaaaaaaaaajv","aaaaaaaaaaaaaajw",
        "aaaaaaaaaaaaaajx","aaaaaaaaaaaaaajy","aaaaaaaaaaaaaajz","aaaaaaaaaaaaaaka",
        "aaaaaaaaaaaaaakb","aaaaaaaaaaaaaakc","aaaaaaaaaaaaaakd","aaaaaaaaaaaaaake",
        "aaaaaaaaaaaaaakf","aaaaaaaaaaaaaakg","aaaaaaaaaaaaaakh","aaaaaaaaaaaaaaki",
        "aaaaaaaaaaaaaakj","aaaaaaaaaaaaaakk","aaaaaaaaaaaaaakl","aaaaaaaaaaaaaakm",
        "aaaaaaaaaaaaaakn","aaaaaaaaaaaaaako","aaaaaaaaaaaaaakp","aaaaaaaaaaaaaakq",
        "aaaaaaaaaaaaaakr","aaaaaaaaaaaaaaks","aaaaaaaaaaaaaakt","aaaaaaaaaaaaaaku",
        "aaaaaaaaaaaaaakv","aaaaaaaaaaaaaakw","aaaaaaaaaaaaaakx","aaaaaaaaaaaaaaky",
        "aaaaaaaaaaaaaakz","aaaaaaaaaaaaaala","aaaaaaaaaaaaaalb","aaaaaaaaaaaaaalc",
        "aaaaaaaaaaaaaald","aaaaaaaaaaaaaale","aaaaaaaaaaaaaalf","aaaaaaaaaaaaaalg",
        "aaaaaaaaaaaaaalh","aaaaaaaaaaaaaali","aaaaaaaaaaaaaalj","aaaaaaaaaaaaaalk",
        "aaaaaaaaaaaaaall","aaaaaaaaaaaaaalm","aaaaaaaaaaaaaaln","aaaaaaaaaaaaaalo",
        "aaaaaaaaaaaaaalp","aaaaaaaaaaaaaalq","aaaaaaaaaaaaaalr","aaaaaaaaaaaaaals",
        "aaaaaaaaaaaaaalt","aaaaaaaaaaaaaalu","aaaaaaaaaaaaaalv","aaaaaaaaaaaaaalw",
        "aaaaaaaaaaaaaalx","aaaaaaaaaaaaaaly","aaaaaaaaaaaaaalz","aaaaaaaaaaaaaama",
        "aaaaaaaaaaaaaamb","aaaaaaaaaaaaaamc","aaaaaaaaaaaaaamd","aaaaaaaaaaaaaame",
        "aaaaaaaaaaaaaamf","aaaaaaaaaaaaaamg","aaaaaaaaaaaaaamh","aaaaaaaaaaaaaami",
        "aaaaaaaaaaaaaamj","aaaaaaaaaaaaaamk","aaaaaaaaaaaaaaml","aaaaaaaaaaaaaamm",
        "aaaaaaaaaaaaaamn","aaaaaaaaaaaaaamo","aaaaaaaaaaaaaamp","aaaaaaaaaaaaaamq",
        "aaaaaaaaaaaaaamr","aaaaaaaaaaaaaams","aaaaaaaaaaaaaamt","aaaaaaaaaaaaaamu",
        "aaaaaaaaaaaaaamv","aaaaaaaaaaaaaamw","aaaaaaaaaaaaaamx","aaaaaaaaaaaaaamy",
        "aaaaaaaaaaaaaamz","aaaaaaaaaaaaaana","aaaaaaaaaaaaaanb","aaaaaaaaaaaaaanc",
        "aaaaaaaaaaaaaand","aaaaaaaaaaaaaane","aaaaaaaaaaaaaanf","aaaaaaaaaaaaaang",
        "aaaaaaaaaaaaaanh","aaaaaaaaaaaaaani","aaaaaaaaaaaaaanj","aaaaaaaaaaaaaank",
        "aaaaaaaaaaaaaanl","aaaaaaaaaaaaaanm","aaaaaaaaaaaaaann","aaaaaaaaaaaaaano",
        "aaaaaaaaaaaaaanp","aaaaaaaaaaaaaanq","aaaaaaaaaaaaaanr","aaaaaaaaaaaaaans",
        "aaaaaaaaaaaaaant","aaaaaaaaaaaaaanu","aaaaaaaaaaaaaanv","aaaaaaaaaaaaaanw",
        "aaaaaaaaaaaaaanx","aaaaaaaaaaaaaany","aaaaaaaaaaaaaanz","aaaaaaaaaaaaaaoa",
        "aaaaaaaaaaaaaaob","aaaaaaaaaaaaaaoc","aaaaaaaaaaaaaaod","aaaaaaaaaaaaaaoe",
        "aaaaaaaaaaaaaaof","aaaaaaaaaaaaaaog","aaaaaaaaaaaaaaoh","aaaaaaaaaaaaaaoi",
        "aaaaaaaaaaaaaaoj","aaaaaaaaaaaaaaok","aaaaaaaaaaaaaaol","aaaaaaaaaaaaaaom",
        "aaaaaaaaaaaaaaon","aaaaaaaaaaaaaaoo","aaaaaaaaaaaaaaop","aaaaaaaaaaaaaaoq",
        "aaaaaaaaaaaaaaor","aaaaaaaaaaaaaaos","aaaaaaaaaaaaaaot","aaaaaaaaaaaaaaou",
        "aaaaaaaaaaaaaaov","aaaaaaaaaaaaaaow","aaaaaaaaaaaaaaox","aaaaaaaaaaaaaaoy",
        "aaaaaaaaaaaaaaoz","aaaaaaaaaaaaaapa","aaaaaaaaaaaaaapb","aaaaaaaaaaaaaapc",
        "aaaaaaaaaaaaaapd","aaaaaaaaaaaaaape","aaaaaaaaaaaaaapf","aaaaaaaaaaaaaapg",
        "aaaaaaaaaaaaaaph","aaaaaaaaaaaaaapi","aaaaaaaaaaaaaapj","aaaaaaaaaaaaaapk",
        "aaaaaaaaaaaaaapl","aaaaaaaaaaaaaapm","aaaaaaaaaaaaaapn","aaaaaaaaaaaaaapo",
        "aaaaaaaaaaaaaapp","aaaaaaaaaaaaaapq","aaaaaaaaaaaaaapr","aaaaaaaaaaaaaaps",
        "aaaaaaaaaaaaaapt","aaaaaaaaaaaaaapu","aaaaaaaaaaaaaapv","aaaaaaaaaaaaaapw",
        "aaaaaaaaaaaaaali","aaaaaaaaaaaaaalj","aaaaaaaaaaaaaalk","aaaaaaaaaaaaaall"};
    char[][] board = getBoard(boardString);
    solution.findWords(board, words);
  }

  private char[][] getBoard(String[] boardString) {
    int len = boardString.length;
    int wordLen = boardString[0].length();
    char[][] result = new char[len][wordLen];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < wordLen; j++) {
        result[i][j] = boardString[i].charAt(j);
      }
    }
    return result;
  }
}
