package lime._642_Design_Search_Autocomplete_System;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/9/2021
 */
class AutocompleteSystemITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<AutocompleteSystem> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final String[] input = {"i love you", "island", "ironman", "i love leetcode"};
    final int[] times = {5, 3, 2, 2};
    final AutocompleteSystem autocompleteSystem =
        solutionClass.getConstructor(String[].class, int[].class).newInstance(input, times);
    final Set<String> expectedI = Set.of("i love you", "island", "i love leetcode");
    assertEquals(expectedI, new HashSet<>(autocompleteSystem.input('i')));
    final Set<String> expectedSpace = Set.of("i love you", "i love leetcode");
    assertEquals(expectedSpace, new HashSet<>(autocompleteSystem.input(' ')));
    final Set<String> expectedA = Set.of();
    assertEquals(expectedA, new HashSet<>(autocompleteSystem.input('a')));
    final Set<String> expectedPound = Set.of();
    assertEquals(expectedPound, new HashSet<>(autocompleteSystem.input('#')));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<AutocompleteSystem> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final String[] input = {"abc", "abbc", "a"};
    final int[] times = {3, 3, 3};
    final AutocompleteSystem autocompleteSystem =
        solutionClass.getConstructor(String[].class, int[].class).newInstance(input, times);
    final Set<String> expectedB = Set.of();
    assertEquals(expectedB, new HashSet<>(autocompleteSystem.input('b')));
    final Set<String> expectedC = Set.of();
    assertEquals(expectedC, new HashSet<>(autocompleteSystem.input('c')));
    final Set<String> expectedSpace = Set.of();
    assertEquals(expectedSpace, new HashSet<>(autocompleteSystem.input('#')));

    final Set<String> expectedBAgain = Set.of("bc");
    assertEquals(expectedBAgain, new HashSet<>(autocompleteSystem.input('b')));
    assertEquals(expectedBAgain, new HashSet<>(autocompleteSystem.input('c')));
    assertEquals(expectedSpace, new HashSet<>(autocompleteSystem.input('#')));

    final List<String> afterA = List.of("a", "abbc", "abc");
    assertEquals(afterA, autocompleteSystem.input('a'));
    final List<String> afterB = List.of("abbc", "abc");
    assertEquals(afterB, autocompleteSystem.input('b'));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Class<AutocompleteSystem> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {

    final int[] times = {12, 9, 4, 4, 1, 5, 3, 4, 7, 9, 2, 4, 2, 3, 11, 13, 1, 3, 4, 10, 7, 1, 9, 5, 10, 14, 5, 3, 2,
        11, 5, 14, 4, 13, 11, 5, 15, 8, 1, 12, 2, 11, 4, 2, 11, 14, 9, 12, 1, 7, 13, 11, 7, 2, 6, 10};
    final String[] input = {"uqpewwnxyqxxlhiptuzevjxbwedbaozz", "ewftoujyxdgjtazppyztom", "pvyqceqrdrxottnukgbdfcr",
        "qtdkgdbcyozhllfycfjhdsdnuhycqcofaojknuqqnozltrjcabyxrdqwrxvqrztkcxpenbbtnnnkfhmebj",
        "jwfbusbwahyugiaiazysqbxkwgcawpniptbtmhqyrlxdwxxwhtumglihrgizrczv", "cfptjitfzdcrhw",
        "aitqgitjgrcbacgnaasvbouqsqcwbyskkpsnigtfeecmlkcjbgduban",
        "utsqkmiqqgglufourfdpgdmrkbippffacwvtkpflzrvdlkdxykfpkoqcb", "ethtbdopotpamvrwuomlpahtveyw",
        "jiaqkaxovsqtkpdjfbkajpvpyetuoqwnrnpjdhoojbsdvneecsdvgqpyurmsvcy", "j",
        "btbnuplyeuccjbernsfbnveillrwdbqledwvpmvdbcugkurrkabtpykhlcogeszclyfuquafouv", "hndjzblegevtfkgbjttektox",
        "gtvnlninpvenapyfgmsjdisfnmiktitrutctawosjflvzfkbegnprixzqwzcyhoovsivuwmofsveqkyosowuyamuvy",
        "sawrirvrfrbfagreahrioaombukmdwztbpggnxd", "mgdcwptvbvhzyvvumvbjjn",
        "otjvvkegwleyyxtghwgfmlsqlhrlibdvqfinyyebotjpwoaejhtornfgikmifdmwswbqgwhcbzuhrpajxuqicegcptszct",
        "zlondsttyvnnnnxjtoqnlktitwzurissczzbyfsbgpoawodwjpsmavaugnhqtsbeixwl",
        "yehvdehbtmwqkmcjmvpivfzqvevkotwzvjoyfvp",
        "bjximtpayjdcxbrnksbtfnpynzaygygdflowewprqngdadzdhxcpgapjejojrkzrutgcsfpfvpluagniqimfqddldxqiw",
        "bysyrxfykivyauysytgxfhqcrxliulahuizjvozpywrokxujhzpauxwufcxiitukljiiclatfrspqcljjoxpxziumstnhqr",
        "uxtvutlgqapyfltiulwrplesmtowzoyhhjhzihatpuvmutxqgxfawpwypedbz",
        "jzgsdjdawrqfladolduldhpdpagmvllvzamypuqlrpbmhxxadqaqrqavtxeghcyysjynovkiyjtvdluttodtmtocajgttmv",
        "mbijfkmepalhdiubposdksdmmttxblkodcdrxbnxaqebnwliatnxpwaohbwkidia", "ljggggbyxwrwanhjonoramexdmgjigrtpz",
        "cqfvkutpipxjepfgsufonvjtotwfxyn", "kvseesjazssavispavchdpzvdhibptowhyrrshyntpwkez",
        "nveuzbaosuayteiozmnelxlwkrrrjlwvhejxhupvchfwmvnqukphgoacnazuoimcliubvhv", "uwrpwhfdrxfnarxqpkhrylkwiuhzubjfk"
        , "bniyggdcloefwy", "ihranmhbsahqjxesbtmdkjfsupzdzjvdfovgbtwhqfjdddwhdvrnlyscvqlnqpzegnvvzyymrajvso",
        "lscreasfuxpdxsiinymuzybjexkpfjiplevqcjxlm",
        "uwgnfozopsygnmptdtmmuumahoungpkodwxrcvfymqpeymaqruayvqqgoddgbnhemtsjifhxwiehncswxzrghf",
        "nyfbxgcpfrzyqwfjzgmhuohjhrjizsyjqgmertmooeiaadcmiuyyylpcosnweoyydeauazhzbeaqn",
        "tpylrxbwnkrfxckfdlvrbytaezuzmyscpvruthuvbxjenkeolvqsrjqzizyclzmqtjvnamdansmzyspcfghfprorqprua",
        "nhldlmxpuckxeekipkrzugatjiivtazjbjyxokksyueyjbgmrovbckbxqcqefaiavzsarbbypgmpxe", "sylraqsd", "xr",
        "xkzpxkhrucyatpatkigvntohihibyisyqtkjdhatdvyvxbjttz", "nvnz",
        "blzddwxphkgqfsfzfclwytstpvpzgcdeggdwzukzirscfzcteeuqbmmrfxcnokbbyxkqrxtjfarcefiynwfmy",
        "inuxmuhtdwpuvyludwtokhtalxbuccepsayrjycbcwbtnfholjvkmypodv", "awwillrm", "xznodxngrstjrwqzmlmigpw",
        "khlxjdtictufdfbkgfusdtaaeuspbbfmtjodflgqofzlqnulkdztflm",
        "nlngmckslyqzjiyiexbropbxnynjcstziluewypboqhqndqsxhtnosrgrameajovsclrgwqjgnztvxrkhwnxkfrf",
        "yroadxhxyacaexrwju", "ujxlbpcbxdqrvubifnpzjmmkolyljzjhdegaiowaal",
        "tnfnjgtxbckbpyplucprxcqzhrfjimylmlhdglntfydepltjvklyxesndzuubienhvuaqc", "ouedhtkpkg",
        "ygchsrrubucqffewifsxaefwocfaiiupqbomktvrcddggqfgnaycstpccwtbheyaqwhosxajqeqqxzyjsfng", "jqqgpjvfkgjh",
        "csowoazaiyejgyixszqmtctpzlkccccqregyhtvxccvrpkupwcyhqatxscevzdfbdqnuyadiyfnhysddfyxpgqtjiogmxsmzbbkr",
        "dlzxdpchkdaztkqtrjmuujgoiae", "plcjkwukkyqluxjbhxsyeaqvviinfuujsafwsquidvmutsrukxwrv",
        "yopqbtpoqhpcktjangauzcvvpephhprpaaclbbkgchlqkrwdsaupeizlwxzcpkchoagmrrkwdkthosmrjefgbumnrjsb"};
    final AutocompleteSystem autocompleteSystem =
        solutionClass.getConstructor(String[].class, int[].class).newInstance(input, times);
    final Set<String> expectedB = Set.of();
    assertEquals(expectedB, new HashSet<>(autocompleteSystem.input('w')));
    assertEquals(expectedB, new HashSet<>(autocompleteSystem.input('o')));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        AutocompleteSystemI.class
    );
  }

}