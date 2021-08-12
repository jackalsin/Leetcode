package _0301_0350._318_Maximum_Product_of_Word_Lengths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/22/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  /**
   * Example 1:
   * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
   * Return 16
   * The two words can be "abcw", "xtfn".
   *
   * @throws Exception
   */
  @Test
  public void testOnlineCase1() throws Exception {
    final String[] input = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    assertEquals(16, solution.maxProduct(input));
  }

  /**
   * Example 2:
   * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
   * Return 4
   * The two words can be "ab", "cd".
   *
   * @throws Exception
   */
  @Test
  public void testOnlineCase2() throws Exception {
    final String[] input = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
    assertEquals(4, solution.maxProduct(input));
  }

  /**
   * Example 3:
   * Given ["a", "aa", "aaa", "aaaa"]
   * Return 0
   * No such pair of words.
   *
   * @throws Exception
   */
  @Test
  public void testOnlineCase3() throws Exception {
    final String[] input = {"a", "aa", "aaa", "aaaa"};
    assertEquals(0, solution.maxProduct(input));
  }

  @Test
  public void testTLE1() throws Exception {
    final String[] input = {"nbalcfjnanoppdhilekcaphnkbkghcanofjjpmb", "pbdfdhfeemhbjgebfkeg",
        "caonnooicbndipikhkhnaf", "aingbpobfjighembab", "lbdkejlcmklh", "pbgmlcndjpkkcfeeodiijhfaibo",
        "nhmjlidbmcaobaepnbmiakffkaipmcehcigickafjd", "khdoh", "onoihaldinmdo",
        "jmjkdodeakjbabaceemlgblanfklfgih", "cbobnmmpfemndnbmdmmlndlpdlmgacjinlfci", "dbehmpjcggng",
        "hpdcpmakaagpphjlpnchkkmhpnlhadhmkmajljbadlacig", "manmgckofglkocigbjglggfbfceokoapnmeg",
        "iamkjjgk", "npnlmhbahhlhdbcjdpebmfdfclfbimcbbaebafabgmfhfpollgc", "egmjejh",
        "kfjdhfccehokakldjeggnppfnebfipkdfmocmp", "fdhngmofijlmhjogiljaeckfnckhdfldhbomjlpaaijk",
        "igoinchjicokemiddicgiebnidljhbjjblncfmacfbeceipj", "hddkfonfjphjmdednandgndgpddfkdiangc",
        "gcikmgomokmnibcaadicpihpfekgdjamaconm", "eegbhklo", "fdpamgkpeopiadljcfkkmcd", "ppajhmdfg",
        "nkgaphipa", "ippbiookdmgfaepopjcilbi", "pnobd", "elganglkmfdmcpneejilpclhndmbmikbgd",
        "ihnbkbpffmcekhbhjkkbpjechppppfbilkjfnolmcbmj", "fmchhinbfmjkepipfphokolocdhhnkfhonikfphjandcfgodl", "fnpjhoeaopkeldnokdomjcflbohjgi", "mehjdnlnfopdoobaongbbodfjlcgnhh", "jo", "dill", "gjpgdlcijcmkffpigoh", "ohggjdmhebeknkbnkgkfebcdamplbklojagbkdjioiebkbfd", "khbenhionagfpafjilkjpfocl", "mhj", "lhoicoiffiejeifcahlfdbdhkcigbblpaonbaihci", "flobjnoajgemplbojcjia", "khpfijpijdabfnmlcdfafkehbnblbbghlliaakofidndlm", "gfaaifflmlfaememmffgnofaofmpnog", "kinfmahiablbjiheccp", "ifhmdenjlgjhnahgedplmjnledijdii", "dfkonfilakegclkd", "jmngfjkieeafmjhj", "jo", "mccphkfaoojklfcjpgmfalnekj", "jmhknfnpbcnnbfpddlmkllooanakkcecipgiapde", "mekdi", "nafffemfbchno", "kbkomkiojhcjmhgkihbnkdli", "lbdh", "dcocbolpahhaebcbdobkgdppmef", "chlebaocfadncmpigcohjdnmcimbcpaciccnfpnbpmjljfhkk", "gnhofncignfbdbkjhopeibekkeokad", "bffijbclnnajhjlhbphkahnboaihmepmh", "dfllfhkljkbfepomiombhnhgbncfahkfdphehmkoo", "cofkdjoebjjmmebilnfebpmfpp", "moeenlhcdkfnbmb", "gehjjimgccjlgejglfkbjjhdegdmoocoecighgjpoplk", "iklliinfljgb", "bmgmdlmkoejpggdjengahc", "iihe", "obhjijbajkdgklaadnjmonnefmckjagpdnldmeplkh", "lkfigniejkeghnpmkdfhdbplmdimcp", "fojiaehoopmdhllanckpabopmkndihgp", "pehfgmblgamhjgd", "iallldlgahhkmonglmphjgcenejfgbhaaklbmfboamj", "fegipmjofekcpipkholgccjdajbed", "ekkepdjofmhckfgheinbehijnbbgadjjoldaamjj", "hnckkckfapjcknlepiabdbmijbkk", "moo", "ldmiigbcgkmkflgepfcgdenghalenkdbgoijmhfmflmpicnc", "dkblepcceffpbadmmamggdopea", "caademhlobbbgngmpiighfohehd", "bfkohoklpiahcboddcfchnlbgokkdf", "fghdicbghobnggkmnamfbnef", "hamgjnfphiifbinonbdgefechlnbiejebnnmdgeobgmkh", "lgpecfhdlbmdjocghjdjmbehghklkhn", "cmkapapdelhcopbpgdhmdelndkjbcjlflgjgiopjoholmnki", "mmelajjlkichdpalbdnhnfjfkoindkmlggeallcnogfjpdfm", "kbbcfboki", "onmfihfgmagffkoo", "anilbbfbhkikkhnhkhjfnn", "ipikhfpghjbdhn", "mabhljplblhflaadnfnlchmcohiljgephhoa", "cmfjhgonnhckhoknofekgojcmjaffj", "glnadlpjnp", "gbhbmmkkgdgjcahjdlkggajdicolfmi", "nlbhbhkealbkgekfjpmpnbmllahcjdiig", "mimmjejmlnbjedh", "kefafgncpgieggpccblloiaeppkkegkfbcbhia", "obllcapokoimg", "hpchdkgboicgmehmpjpckhnhojm", "dbhjikpjieigipnpgjbikfo", "nddgccbmjbjhglmkmmpjcbhlik", "dhg", "gjeogkppepdpplmpnahbelliiiebhijl", "pldngdbhiceckdplnjehkifgimgmlaopcddfnailkoolinoj", "caojnkepfmkecbimbelfmdbijmgdnodggipefgoblingolo", "djaidedgadinbbipgmpmaabplhdlbehhddnkbgakfkockdm", "ndfpjcdpcogjgofkjppdjhckhohafchoekghoeaomop", "jnkj", "bnbaogiamcnbfj", "amcfhlmachdkmokikjcfajfpodpgmggkjiajhgh", "hhcnhmo", "pdaimpnebhafajkddchmmhlohmekbedlhhn", "oglaapoknficejdlfahoedpnliipgaenaffledi", "lmiabkekhogckgonlbnmiemhmihdahpjmfmkpg", "kabigbifoianbbnadjhkobelaigldpdhdlg", "fbjfdgkhfbbdhlkgmcoeddibkfbado", "femhghcml", "iabgnfjjlknphfeabnjpga", "mfcjgkdmplo", "obiidppcaocoj", "eioheecddllmlljjbbplcmjpidoefolieecemfnnegebgfkfoph", "bolbphgnpikhdefdighiloejjphomildblhi", "hgjlgojnnhmgpkmdjpefpjccpibjnabmkkjadigkfjdgdg", "nlieiabejahdbpgokobfclgfm", "gdmpkfkknbjcpnaoapfojocjloiblmfd", "hppgpecolkchnpipkpiknkhfjkdakh", "gndjnlifhdnpcioflhhomolhljfoejedcpabnienekdimhkhge", "kmieggfbbgpdnfehdkeedkjdcednjffokkagk", "hodalomenifoccmbbcfjlhcgoomfapnbolgma", "egihkooncafkilaj", "hepmieadkolhajlpekbojphddiacaomigkamplfbldajed", "mdkobdlmloihcpldebiigdggkbdi", "ijpim"};

    long startTime = System.nanoTime();
    solution.maxProduct(input);
    long endTime = System.nanoTime();
    System.out.println((endTime - startTime) / 1E6);
  }
}
